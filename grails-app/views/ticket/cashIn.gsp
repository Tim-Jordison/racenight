<%--
  Created by IntelliJ IDEA.
  User: coop2
  Date: 2015-10-12
  Time: 9:34 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create Ticket</title>
    <parameter name="EVENTUUID" value="${event.uuid}"/>
    <r:require modules="ticket"/>
</head>

<body>
<g:if test="${ticket.cashedIn}">
    This ticket has already been paid out.
</g:if>
<g:else>
    <g:if test="${unfinishedRaces.size() == 0}">
        <h1>Payout <racenight:displayDollarsAndCentsFromCents cents="${ticket.payoutInCents}"/></h1>
        <table class="pretty-table centered">
            <thead>
            <tr>
                <th>Bet</th>
                <th>Cost</th>
                <th>Payout</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${bets}" var="bet">
                <tr>
                    <td>${bet.description}</td>
                    <td><racenight:displayDollarsAndCentsFromCents cents="${bet.costInCents}"/></td>
                    <td><racenight:displayDollarsAndCentsFromCents cents="${bet.payoutInCents}"/></td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:link action="payout" class="button" params="${[ticketUUID: ticket.uuid]}" onclick="return confirm('This will set the ticket as paid our for \$${ticket.payoutInCents/100}.')">Payout</g:link>
    </g:if>
    <g:else>
        This ticket cannot be cashed because the following races have not yet completed.
        <ul>
            <g:each in="${unfinishedRaces}" var="${race}">
                <li>${race}</li>
            </g:each>
        </ul>
    </g:else>
</g:else>

</body>
</html>

