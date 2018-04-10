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
<h1>Enter Ticket Id</h1>
${message}
<g:form action="cashIn">
    <g:field type="string" name="ticketUUID" placeholder="ticket id"/>
    <g:submitButton name="login" value="Sign in" class="button blue"/>
</g:form>
</body>
</html>

