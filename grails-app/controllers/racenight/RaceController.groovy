package racenight

import com.helperbeans.RaceStubBean
import grails.converters.JSON

class RaceController {
    private static int DEFAULT_HORSE_COUNT = 8;
    def raceService

    def index(Long id) {
        Event event = Event.findByUuid(params.EVENTUUID, [readOnly: true])
        Race race = Race.read(id)
        List<Horse> horses = Horse.findAllByRace(race, [sort: "number", order: "asc"])
        int placedHorses = 0
        Long betsInCents = Bet.createCriteria().get {
            projections {
                sum("costInCents")
            }
            eq("race", race)
            ticket {
                eq("active",true)
            }
        }

        horses.each {
            if (it.placement != null){
                placedHorses++
            }
        }
        [event: event, race: race, horses: horses, placedHorses: placedHorses, betsInCents: betsInCents]
    }


    // ajax
    def create(){
        def model = [:]
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        Integer count = Race.countByEvent(event)
        String name = params.name ?: "Race ${count+1}"
        Race race = new Race(name: name, event: event, finished: false)
        race.save()
        List<Horse> horses = []
        for (int i = 0; i < DEFAULT_HORSE_COUNT; i++){
            horses.add(raceService.createHorse(race, i))
        }
        model.raceId = race.id
        model.html = g.render(template: "/includes/raceStub", model: [raceBean: new RaceStubBean(race, horses.size(), null)])
        render model as JSON
    }

    def delete(){
        def model = [success: false]
        Race race = Race.get(params.id)
        List<Horse> horses = Horse.findAllByRace(race)
        horses*.delete()
        race.delete()
        model.success = true
        render model as JSON
    }
    // ajax
    def addHorse(){
        def model = [success:false]
        Race race = Race.read(params.id)
        int nuberOfHorsesInRace = Horse.countByRace(race)
        Horse horse = raceService.createHorse(race, nuberOfHorsesInRace)
        horse.save()
        model.html = g.render(template: "/includes/horse", model: [horse: horse])
        model.horseNumber = horse.number
        model.success = true
        render model as JSON
    }

    def setHorsePlacement(){
        def model = [success: false]
        Race race = Race.read(params.raceId)
        if (!race.finished){
            Horse horse = Horse.get(params.horseId)
            int placement = params.placement as int
            raceService.setHorsePlacement(race, horse, placement)
            model.success = true
        }
        render model as JSON
    }

    def resetPlacements(){
        def model = [success: false]
        Race race = Race.get(params.raceId)
        if (!race.finished){
            raceService.resetPlacements(race)
            model.success = true
        }
        render model as JSON
    }

    def lockResults(){
        def model = [success: false]
        Race race = Race.get(params.raceId)
        //todo extra logic if there aren't enough place horses. Should depend on scheme.
        if (Horse.countByRaceAndPlacementIsNotNull(race) > 0){
            raceService.completeRace(race)
            model.success = true
        }

        render model as JSON
    }

    def displayOdds(Long id){
        Event event = Event.findByUuid(params.EVENTUUID, [readOnly: true])
        Race race = Race.read(id)
        Long updateInterval = params.updateInterval as Long ?: 30000L
        [event: event, race: race, updateInterval: updateInterval]
    }

    def getOddsAndPayout(Long id){
        def model = [:]
        Event event = Event.findByUuid(params.EVENTUUID, [readOnly: true])
        Race race = Race.read(id)
        Long previousBetCount = params.previousBetCount as Long
        Long newBetCount = Bet.countByRace(race)
        Boolean firstCall = params.firstCall as Boolean
        if (!firstCall && previousBetCount == newBetCount){
            model.failure = true
            return model as JSON
        }

        def horses = raceService.getOddsForRace(race)
        Long betPriceInCents = event.betPriceInCents
        Long totalBetCount = Bet.createCriteria().get() {
            projections {
                sum("numberOfBets")
            }
            eq('race', race)
            ticket {
                eq("active",true)
            }

        } ?: 0L

        Long prizePoolInCents = betPriceInCents * totalBetCount * event.payoutRate

        List<Horse> allHorses = Horse.findAllByRace(race, [sort: 'id', order: 'asc'])

        List<Horse> horsesWithNoBets = []
        for (Horse horse in allHorses){
            boolean inPagedList = false
            for (def horseFromMap in horses){
                if (horse.number == horseFromMap.number as Long){
                    inPagedList = true
                }
            }
            if (!inPagedList){
                horsesWithNoBets.add(horse)
            }
        }

        def resultsForView = []
        for (def horse in horses){
            resultsForView[(horse.number as Integer) - 1] = horse
        }
        for (Horse horse in horsesWithNoBets){
            def horseMap = [:]
            horseMap.number = horse.number
            horseMap.name = horse.name
            horseMap.numberOfBets = 0
            resultsForView[horse.number - 1] = horseMap
        }

        String now = (new Date()).format("MMM dd, yyyy, HH:mm:ss")


        model.html = g.render(template: "/includes/oddsTable", model: [horses:resultsForView, prizePoolInCents: prizePoolInCents, totalBetCount: totalBetCount, now: now])
        render model as JSON
    }


}
