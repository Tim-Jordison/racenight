<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Triple Crown Racing</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${resource(dir: 'images/custom', file: 'tcr_favicon_85x85.png')}" type="image/x-icon">
	<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
	<g:set var="EVENTUUID" value="${pageProperty(name: 'page.EVENTUUID')}"/>
	<r:require modules="base"/>
	<g:layoutHead/>
	<r:layoutResources />
</head>
<body>
<div class="top-transparent-div">
</div>
<div class="top-bar">
	<g:link url="/"><img src="${resource(dir:'images/custom', file:"triple_crown_racing_logo_741x101.png")}" width="330" height="45" class="top-logo"/></g:link>
	<g:link class="button menu-item" controller="events" action="list">Events List</g:link>
	<g:link class="button menu-item" controller="events" action="create">Create Event</g:link>
</div>
<g:if test="${EVENTUUID}">
<div class="navigation-transparent-div">
</div>
<div class="navigation-bar">
	<div class="navigation-bar-contents">
		<div class="menu-item">
			<g:link controller="events" action="index">Races</g:link>
		</div>
		<div class="menu-item">
			<g:link controller="ticket" action="list">Tickets</g:link>
		</div>
		<div class="menu-item">
			<g:link controller="ticket" action="create">Create Ticket</g:link>
		</div>
		<div class="menu-item">
			<g:link controller="ticket" action="enterTicket">Cash In</g:link>
		</div>
	</div>
</div>
</g:if>
<div class="content-section-background"></div>
<div class="wrapper">
	<div class="content-section">
		<g:layoutBody/>
	</div>
	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	<r:layoutResources />
	<div class="footer">
		<p>Tim Jordison<br>
		<a href="mailto:jordisontl@gmail.com">jordisontl@gmail.com</a></p>
	</div>
</div>
</body>
</html>
