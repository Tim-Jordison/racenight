<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Tickets</title>
    <parameter name="EVENTUUID" value="${event.uuid}"/>
    <r:require modules="ticket"/>
</head>

<body>
<div class="heading">
    <h1 class="event-title">Tickets</h1>
    <span class="event-info">
        Total Value: <racenight:displayDollarsAndCentsFromCents cents="${totalValue}"/><br/>
        Total Paid Out: <racenight:displayDollarsAndCentsFromCents cents="${totalPaidOut}"/> (${ticketsPaidOut} tickets paid out)<br/>
        Float: <racenight:displayDollarsAndCentsFromCents cents="${totalValue - totalPaidOut}"/> (${tickets.size() - ticketsPaidOut} tickets remaining to be paid out)
    </span>
    <g:link action="create" class="button add-ticket">New Ticket</g:link>
</div>
<div class="clear"></div>
%{--<input id="race-name"/>--}%
<div class="races">
    <table class="pretty-table centered">
        <thead>
            <tr>
                <th>Ticket Id</th>
                <g:sortableColumn property="priceInCents" action="list" title="Price"/>
                <g:sortableColumn property="dateActivated" action="list" title="Activated"/>
                <g:sortableColumn property="cashedIn" action="list" title="Status"/>
            </tr>
        </thead>
        <tbody>
        <g:each in="${tickets}" var="ticket">
            <tr>
                <td><g:link action="index" id="${ticket.id}">${ticket.uuid}</g:link></td>
                <td><racenight:displayDollarsAndCentsFromCents cents="${ticket.priceInCents}"/><br/></td>
                <td><racenight:dateAndTime date="${ticket.dateActivated}"/></td>
                <td>
                    <g:if test="${ticket.cashedIn}">
                        <racenight:dateAndTime date="${ticket.dateCashedIn}"/>
                    </g:if>
                    <g:else>
                        outstanding
                    </g:else>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>

</div>

</body>
</html>