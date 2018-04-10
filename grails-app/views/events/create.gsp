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
    <title>Create Event</title>
</head>

<body>
<h1>Create event</h1>
<g:if test="${error}">
    Sorry something went wrong. Please try again.
</g:if>
<g:form controller="events" action="save">
    <g:field type="string" name="name" placeholder="Event Name"/>
    <g:field type="password" name="password" placeholder="Password"/>
    <g:field type="decimal" name="payoutRate" placeholder="Payout Rate"/>
    <g:field type="decimal" name="betPriceInDollarsAndCents" placeholder="Ticket Price"/>
    <g:submitButton name="login" value="Create Event" class="button blue"/>
</g:form>



</body>
</html>