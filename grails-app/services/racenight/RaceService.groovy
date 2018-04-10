package racenight

import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional
class RaceService {
    def betService

    public Horse createHorse(Race race, int horsesInRaceCount) {
        int horseNumber = horsesInRaceCount + 1
        Horse horse = new Horse(name: "horse ${horseNumber}", race: race, number: horseNumber, placement: null)
        horse.save()
        return horse
    }

    public void setHorsePlacement(Race race, Horse horse, int placement){
        Horse otherHorse = Horse.findByPlacementAndRace(placement, race)
        if (otherHorse){
            otherHorse.placement = null
            otherHorse.save()
        }
        horse.placement = placement
        horse.save()
    }

    public void resetPlacements(Race race){
        List<Horse> horses = Horse.findAllByRaceAndPlacementIsNotNull(race)
        horses*.placement = null
        horses*.save()
    }

    public void completeRace(Race race){
        betService.calculateAndSetPayoutOnAllBetsForRace(race)
        race.finished = true
        race.dateFinished = new Date()
        race.save()
    }

    def getOddsForRace(Race race){
        def result = Bet.createCriteria().list([readOnly: true, sort: 'horse', order: 'asc']) {
            resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
            projections {
                sum('numberOfBets', 'numberOfBets')
                horse {
                    property("number",'number')
                    property("name","name")
                }
//                property('horse.id', 'horseId')
//                property('horse.name', 'horseName')
            }
            eq('race',race)
            groupProperty('horse')
            ticket {
                eq("active",true)
            }
        }
    }
}
