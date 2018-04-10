package racenight

import com.helperbeans.RaceStubBean

class EventsController {

    def index(){
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        List<RaceStubBean> raceBeans = []

        List<Race> races = Race.findAllByEvent(event, [sort: 'id', order: 'asc'])
        for (Race race in races){
            String horsesPlacements = null
            if (race.finished){
                horsesPlacements = Horse.findAllByRaceAndPlacementIsNotNull(race, [sort: 'placement', order: 'asc'])*.number.toString()
            }
            raceBeans.add(new RaceStubBean(race, Horse.countByRace(race), horsesPlacements))
        }
        params.BACKTOEVENT = false
        [event: event, raceBeans: raceBeans]
    }

    def list() {
        List<Event> events = Event.list([sort: params.sort, order: params.order, max: params.max, offset: params.offset])
        [events: events]
    }


    def create(){

    }

    def save(){
        Event event = null
        Boolean success = false
        try {
            Float betPriceInDollarsAndCents = params.betPriceInDollarsAndCents as Float
            Long betPriceInCents = Math.round(betPriceInDollarsAndCents * 100)
            event = new Event(name: params.name, password: params.password, payoutRate: params.payoutRate as Float, betPriceInCents: betPriceInCents)
            success = event.validate()
        } catch (Exception e){
            success = false
        }
        if (!success){
            render(view: "create", model: [error: true])
            return
        } else {
            event.save()
            session.putValue("eventUUID",event.uuid)
            redirect(action: "index")
        }
    }

    def loginToEvent(){
        Event event = null
        if (params.name && params.password){
            event = Event.findByNameIlikeAndPassword(params.name, params.password)
        }
        if (event){
            session.putValue("eventUUID", event.uuid)
            redirect(action: "index")
        }
        [name: params.name ?: null, error: true]
    }


}
