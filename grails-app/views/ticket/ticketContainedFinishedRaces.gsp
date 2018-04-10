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
  <r:require modules="event, ticket"/>
</head>

<body>
The ticket contained bets for races that have finished. The ticket could not be created.
${finishedRaces*.name+" "}
</body>
</html>

