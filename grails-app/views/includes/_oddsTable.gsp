Updated ${now}
<table class="pretty-table">
    <thead>
    <tr>
        <th>Horse</th>
        <th>Payout Odds</th>
        <th>Bet Payout</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${horses}" var="horse">
        <tr>
            <td>(#${horse.number}) ${horse.name}</td>
            <td>${totalBetCount} to ${horse.numberOfBets}</td>
            <td><racenight:displayDollarsRounderDownToQuarterFromCents cents="${prizePoolInCents / (horse.numberOfBets ?: 1)}"/></td>
        </tr>

    </g:each>
    </tbody>
</table>