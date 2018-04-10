<%--
  Created by IntelliJ IDEA.
  User: coop2
  Date: 2015-09-17
  Time: 6:39 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Race</title>
    <r:require modules="races"/>
    <parameter name="EVENTUUID" value="${event.uuid}"/>
    <script>
        window.raceId = ${race.id};
        window.placedHorses = ${placedHorses};

    </script>
</head>

<body>
<div class="heading">
    <h1 class="event-title renamer-field" data-class="${com.enums.ChangeableNameDomainClassEnum.RACE}" data-id="${race.id}">${race.name}</h1>
    Bets: <racenight:displayDollarsAndCentsFromCents cents="${betsInCents}"/>
</div>
<div class="clear"></div>
%{--<input id="race-name"/>--}%
<div class="races">
    <g:link class="button" action="displayOdds" id="${race.id}">View Odds</g:link>
    <g:render template="../includes/race" model="${[race: race, horses: horses]}"/>
</div>

</body>
</html>