<div class="heading">
    <h1 class="event-title">Ticket Overview</h1>
    <g:if test="${ticket.active}">
        Activated <racenight:dateAndTime date="${ticket.dateActivated}"/><br/>
        <g:if test="${ticket.cashedIn}">
            Paid out on <racenight:dateAndTime date="${ticket.dateCashedIn}"/><br/>
            Paid out: <racenight:displayDollarsAndCentsFromCents cents="${ticket.payoutInCents}"/><br/>
        </g:if>
        <g:else>
            <g:link class="button add-ticket" action="cashIn" params="${[ticketUUID: ticket.uuid]}">Cash-in</g:link>
        </g:else>
    </g:if>
    <g:else>
        Not yet active<br/>
    </g:else>
    Id: ${ticket.uuid}

</div>
<div class="clear"></div>
<table class="pretty-table centered" id="bets-table">
    <thead>
    <tr>
        <th>Horse / Race</th>
        <th>Quantity</th>
        <th>Cost</th>
        <g:if test="${ticket.cashedIn}">
            <th>Payout</th>
        </g:if>
    </tr>
    </thead>
    <tbody>
    <g:each in="${bets}" var="bet">
        <tr>
            <td>${bet.description}</td>
            <td>${bet.numberOfBets}</td>
            <td><racenight:displayDollarsAndCentsFromCents cents="${bet.costInCents}"/></td>
            <g:if test="${ticket.cashedIn}">
                <td><racenight:displayDollarsAndCentsFromCents cents="${bet.payoutInCents}"/></td>
            </g:if>
        </tr>

    </g:each>
    <tr>
        <td>Total</td>
        <td>${totalBets}</td>
        <td><racenight:displayDollarsAndCentsFromCents cents="${ticket.priceInCents}"/></td>
        <g:if test="${ticket.cashedIn}">
            <td>
                <racenight:displayDollarsAndCentsFromCents cents="${ticket.payoutInCents}"/>
            </td>
        </g:if>
    </tr>
    </tbody>
</table>

<div id="printableArea" class="hidden">
    <g:render template="/ticket/print" model="${[ticket: ticket, bets: bets, event: event]}"/>
</div>

