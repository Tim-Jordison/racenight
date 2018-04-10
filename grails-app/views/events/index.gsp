<%--
  Created by IntelliJ IDEA.
  User: coop2
  Date: 2015-09-17
  Time: 6:39 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <parameter name="EVENTUUID" value="${event.uuid}"/>
    <meta name="layout" content="main"/>
    <title>Event</title>
    <r:require modules="event"/>
</head>

<body>
<div class="heading">
    <h1 class="event-title">Event: ${event.name}</h1>
    <span class="event-info">
        payout rate: ${event.payoutRate*100}%, bet price: $${event.betPriceInCents / 100}
    </span>
    <span class="button add-race">Add Race</span>
</div>
<div class="clear"></div>
%{--<input id="race-name"/>--}%
<div class="races">
    <g:each in="${raceBeans}" var="raceBean">
        <g:render template="../includes/raceStub" model="${[raceBean: raceBean]}"/>
    </g:each>
</div>

</body>
</html>