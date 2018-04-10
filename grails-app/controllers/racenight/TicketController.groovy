package racenight

import com.helperbeans.RaceBean
import grails.converters.JSON
import groovy.json.JsonSlurper

class TicketController {
    private static int TICKET_UUID_LENGTH = 5;

    def index(){
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        Ticket ticket = Ticket.read(params.id as Long)
        List<Bet> bets = Bet.findAllByTicket(ticket, [readOnly: true, sort: "horse", order: "asc"])
        [event: event, ticket: ticket, bets: bets]
    }

    def list() {
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        List<Ticket> tickets = Ticket.findAllByEventAndActive(event, true, params)
        long totalValue = 0
        long ticketsPaidOut = 0
        long totalPaidOut = 0
        for (Ticket ticket in tickets){
            totalValue += ticket.priceInCents
            if (ticket.cashedIn){
                totalPaidOut += ticket.payoutInCents
                ticketsPaidOut++
            }
        }


        [event: event, tickets: tickets, totalValue: totalValue, ticketsPaidOut: ticketsPaidOut, totalPaidOut: totalPaidOut]
    }

    def enterTicket(){
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        [event: event, message: params.message]
    }

    def cashIn(){
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        Ticket ticket = Ticket.findByUuid(params.ticketUUID as String)
        if (!ticket){
            redirect(action: "enterTicket", params: [message: "Ticket not found with id ${params.ticketUUID}"])
            return
        } else if (!ticket.active){
            redirect(action: "enterTicket", params: [message: "That ticket is not active. Id ${params.ticketUUID}"])
            return
        }
        List<Bet> bets = Bet.findAllByTicket(ticket)
        long totalPayoutInCents = 0
        List<Race> unfinishedRaces = []
        for (Bet bet in bets){
            if (bet.raceCompleteAndPayoutSet){
                totalPayoutInCents += bet.payoutInCents
            } else {
                unfinishedRaces.add(bet.race)
            }
        }
        ticket.payoutInCents = totalPayoutInCents
        ticket.save()

        [event: event, ticket: ticket, bets: bets, unfinishedRaces: unfinishedRaces]
    }

    def create() {
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        List<Race> races = Race.findAllByEventAndFinished(event, false)
        List<RaceBean> raceBeans = []
        for (Race race in races){
            List<Horse> horses = Horse.findAllByRace(race)
            raceBeans.add(new RaceBean(race, horses))
        }
        String ticketUUID = UUID.randomUUID().toString().substring(0, TICKET_UUID_LENGTH).toUpperCase()
        [event: event, raceBeans: raceBeans, ticketUUID: ticketUUID]
    }

    // todo create view for save that gives summary of ticket
    // todo add activate ticket method - this should check if any of the races have finished
    def save(){
        def model = [success:false]
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        String ticketUUID = params.ticketUUID as String
        if (Ticket.findByUuid(ticketUUID)){
//            todo log throw new IllegalStateException("Duplicated ticket uuid found!")
            render model as JSON
            return
        }
        Ticket ticket = new Ticket(uuid: ticketUUID, event: event, priceInCents: 0)
        ticket.save(flush: true)
        List<Bet> bets = []

        def jsonSlurper = new JsonSlurper()
        def dataMapFromPage = jsonSlurper.parseText(params.bets)

        //Map<Long, Horse> horseMap = [:] //todo improve this to use a map. with caching this might not matter?
        for (Map.Entry<String, String> entry : dataMapFromPage.entrySet())
        {
            Map values = entry.getValue() as Map
            Horse horse = Horse.read(values.horseId as Long)
            Race race = Race.read(values.raceId as Long)
            Long numberOfBets = values.count as Integer
            Bet bet = new Bet(
                    ticket: ticket,
                    race: race,
                    horse: horse,
                    numberOfBets: numberOfBets,
                    costInCents: numberOfBets * event.betPriceInCents,
                    description: (horse.number + ": " + horse.name + " (" + race.name + ")").toString(),
                    raceCompleteAndPayoutSet: false
            )
            bet.save()
            bets.add(bet)
            ticket.priceInCents += bet.costInCents
        }

        Long totalCostInCentsFromBets = bets.sum {it.costInCents} as Long
        if (ticket.priceInCents != totalCostInCentsFromBets){
            throw new IllegalStateException("Values did not line up! ${ticket}, ${totalCostInCentsFromBets}")
        }


        model.success = true
        model.html = g.render(template: "/includes/ticketConfirm", model: [ticket: ticket, bets: bets, event: event, totalBets: bets.sum {it.numberOfBets}])
        render model as JSON
    }

    def confirm(){
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        if (!event){
            return
        }
        Ticket ticket = Ticket.findByUuid(params.ticketUUID as String)
        List<Bet> bets = Bet.findAllByTicket(ticket)
        List<Race> races = bets.collect { it.race }.unique()
        List<Race> finishedRaces = []
        for (Race race in races){
            if (race.finished){
                finishedRaces.add(race)
            }
        }
        if (finishedRaces){
            render(view: "ticketContainedFinishedRaces", model: [finishedRaces: finishedRaces, event: event])
            return
        } else {
            ticket.active = true
            ticket.dateActivated = new Date()
            ticket.save()
            redirect(view: "index", id: ticket.id)
            return
        }
    }

    def payout(){
        Ticket ticket = Ticket.findByUuid(params.ticketUUID as String)
        ticket.dateCashedIn = new Date()
        ticket.cashedIn = true;
        ticket.save()
        redirect(action: "index", id: ticket.id)
    }

    def print(Long id){
        Ticket ticket = Ticket.read(id)
        String currentTime = (new Date()).format("yyyy-MM-dd HH:mm:ss")
        Event event = Event.findByUuid(params.EVENTUUID as String, [readOnly: true])
        List<Bet> bets = Bet.findAllByTicket(ticket, [readOnly: true, sort: "horse", order: "asc"])
        [ticket: ticket, bets: bets, event: event, currentTime: currentTime]
    }
}
