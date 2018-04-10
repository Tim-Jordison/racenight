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
    <title>Event Sign-in</title>
    %{--<link rel="stylesheet" href="${resource(dir: 'css', file: 'homescreen.css')}" type="text/css">--}%
</head>

<body>
<h1>Login to event</h1>
<g:form controller="events" action="loginToEvent">
    <g:field type="string" name="name" value="${params.name}" placeholder="Event name"/>
    <g:field type="password" name="password" placeholder="Password"/>
    <g:submitButton name="login" value="Sign in" class="button blue"/>
</g:form>


</body>
</html>