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
<input type="button" class="button add-ticket" onclick="printDiv('printableArea')" value="print" />
<g:render template="../includes/ticketConfirm" model="${[ticket: ticket, bets: bets, totalBets: bets.sum {it.numberOfBets}]}"/>
<div id="printableArea" class="hidden">
    <g:render template="print" model="${[ticket: ticket, bets: bets, event: event]}"/>
</div>

<script type="text/javascript">
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;

        document.body.innerHTML = printContents;

        window.print();

        document.body.innerHTML = originalContents;
    }
</script>
</body>
</html>

