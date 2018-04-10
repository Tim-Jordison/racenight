<%--
  Created by IntelliJ IDEA.
  User: coop2
  Date: 2015-11-23
  Time: 11:20 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Triple Crown Racing</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images/custom', file: 'tcr_favicon_85x85.png')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <parameter name="EVENTUUID" value="${event.uuid}"/>
    <script type="text/javascript">
        window.raceId = ${race.id};
        window.updateInterval = ${updateInterval};
    </script>
    <r:require modules="base, oddsTable, table, homescreen"/>
    <r:layoutResources/>
</head>

<body>
<div class="homescreen-image"></div>
<div class="odds-table-div">
    <div class="race-sponsor">
        <img class="sponsor-image" src="${race.s3ImageLocation}"/>
    </div>
    <g:link url="/"><img src="${resource(dir:'images/custom', file:"triple_crown_racing_logo_741x101.png")}" width="330" height="45" class="top-logo"/></g:link>
    <h1>${race.name}</h1>
    Bet Price: <racenight:displayDollarsAndCentsFromCents cents="${event.betPriceInCents}"/>

    <div class="odds-table">
    </div>

</div>
<r:layoutResources />
</body>
</html>