<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create Ticket</title>
    <parameter name="EVENTUUID" value="${event.uuid}"/>
    <r:require modules="ticket"/>
    <script type="text/javascript">
        var ticketUUID = "${ticketUUID}";
    </script>
</head>

<body>
<div id="ticket-confirm-replacement">

    <div class="heading">
        <h1>Create Ticket</h1>
    </div>
    <div class="clear"></div>
    <div class="content-left">
        Select horses from races.
        <g:each in="${raceBeans}" var="raceBean">
            <div class="race-container">
                <span class="yellow">${raceBean.race.name}:  </span>
                <g:each in="${raceBean.horses}" var="horse">
                    <a class="horse-button" data-raceId="${raceBean.race.id}" data-horseId="${horse.id}" data-horseName="${horse.name}" data-horseNumber="${horse.number}" data-raceName="${raceBean.race.name}">${horse.number}</a>
                </g:each>
            </div>
        </g:each>
        <g:if test="${raceBeans.size() == 0}">
            <br><br>
            Your event has no races. You can add races from the event page.
        </g:if>
    </div>
    <div class="content-right ${raceBeans.size() == 0 ? "hidden" : ""}">
        <table class="pretty-table" id="bets-table">
            <thead>
            <tr>
                <th>Horse / Race</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <div class="create-button-div">
            <span class="button create-ticket hidden">Create Ticket</span>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="create-button-div hidden">
    <g:link action="confirm" params="${[ticketUUID: ticketUUID]}" class="button create-ticket" onclick="printDiv('printableArea')">Confirm</g:link>
</div>

<script type="text/javascript">
    function printDiv(divName) {
        if (confirm('This will activate the ticket. Have you taken the money for their ticket?')){
            var printContents = document.getElementById(divName).innerHTML;
            var originalContents = document.body.innerHTML;

            document.body.innerHTML = printContents;

            window.print();

            document.body.innerHTML = originalContents;
        }
    }
</script>
</body>
</html>