<%--
  Created by IntelliJ IDEA.
  User: coop2
  Date: 2015-11-17
  Time: 7:09 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <r:require modules="printSources"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'print.css')}" type="text/css">

</head>

<body>
<div class="print-section">
    <h3 class="centered">Triple Crown Racing</h3>
    <div class="centered">
        Event: ${event.name}<br/>
        %{--${currentTime}<br/>--}%
        ${ticket.dateActivated.format("yyyy-MM-dd HH:mm:ss")}<br/>
    </div>
    <br/>
    <br/>
    Your Bets:<br/>
    <hr/>
    <table class="printable-table">
        <thead>
        <tr>
            <th>Horse (#)</th>
            <th>Qty</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${bets}" var="bet">
            <tr>
                <td>${bet.horse.name} (#${bet.horse.number})</td>
                <td>${bet.numberOfBets}</td>
                <td><racenight:displayDollarsAndCentsFromCents cents="${bet.costInCents}"/></td>

            </tr>
        </g:each>
        <tr>
            <td>Total</td>
            <td>${bets*.numberOfBets.sum()} @ <racenight:displayDollarsAndCentsFromCents cents="${event.betPriceInCents}"/></td>
            <td><racenight:displayDollarsAndCentsFromCents cents="${ticket.priceInCents}"/></td>
        </tr>
        </tbody>
    </table>
    <h4 class="centered">${ticket.uuid}</h4>
    <p class="centered">Good luck!</p>

</div>
</body>
</html>