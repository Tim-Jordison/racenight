package racenight

class Bet {
    Horse horse
    static belongsTo = [ticket: Ticket]
    Integer numberOfBets
    Race race //todo should this column be here? I think it should because when the race completes, we can easily set all the payouts on all the bets
    String description
    Long costInCents
    Long payoutInCents
    boolean raceCompleteAndPayoutSet = false

    static constraints = {
        horse nullable: false
        numberOfBets min: 1
        race nulable: false
        description nullable: true
        costInCents nullable: true
        payoutInCents nullable: true
    }
}
