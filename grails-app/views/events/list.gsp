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
    <title>Events</title>
    <r:require modules="table"/>
</head>

<body>
<h1>Events</h1>
<div class="pretty-table">
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="name" title="Name"/>
            <g:sortableColumn property="payoutRate" title="Payout Rate"/>
            <g:sortableColumn property="betPriceInDollarsAndCents" title="Bet Price"/>
            <g:sortableColumn property="dateCreated" title="Date Created"/>
        </tr>
        </thead>
        <tbody>
        <g:each in="${events}" var="event" status="i">
            <tr class="${i % 2 == 0 ? "alt" : ""}">
                <td><g:link action="loginToEvent" params="${[name: event.name]}">${event.name}</g:link></td>
                <td>${event.payoutRate}</td>
                <td>${event.betPriceInCents}</td>
                <td>${event.dateCreated}</td>
            </tr>
        </g:each>


        </tbody>

    </table>
</div>



</body>
</html>