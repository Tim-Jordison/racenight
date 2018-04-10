package racenight

import grails.transaction.Transactional

@Transactional
class BetService {

    public void calculateAndSetPayoutOnAllBetsForRace(Race race) {
        Horse winner = Horse.findByRaceAndPlacement(race, 1)

        Long totalRacePoolInCents = Bet.createCriteria().get {
            projections {
                sum("costInCents")
            }
            eq("race", race)
            ticket {
                eq("active", true)
            }
        }
        Long prizePoolInCents = takeHouseShare(race.event, totalRacePoolInCents)
        Long totalNumberOfWinningBets = Bet.createCriteria().get {
            projections {
                sum("numberOfBets")
            }
            ticket {
                eq("active", true)
            }
            eq("race", race)
            eq("horse", winner)
        } ?: 0L

        List<Bet> winningBets = Bet.createCriteria().list {
            eq("race",race)
            eq("horse",winner)
            ticket {
                eq("active", true)
            }
        }
        if (totalNumberOfWinningBets > 0){
            Long payoutPerBet = Math.round ((prizePoolInCents) / (totalNumberOfWinningBets))
            for (Bet bet in winningBets){
                bet.payoutInCents = payoutPerBet * bet.numberOfBets
                bet.raceCompleteAndPayoutSet = true
                bet.save()
            }
        }

        List<Bet> losingBets = Bet.findAllByRaceAndHorseNotEqual(race, winner)
        for (Bet bet in losingBets){
            bet.payoutInCents = 0
            bet.raceCompleteAndPayoutSet = true
            bet.save()
        }

    }

    public Long takeHouseShare(Event event, Long totalRacePool){
        return Math.round(event.payoutRate * totalRacePool)
    }
}
