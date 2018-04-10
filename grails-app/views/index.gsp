<%@ page import="racenight.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Triple Crown Racing</title>
		<r:require modules="homescreen"/>
	</head>
	<body>
		<div class="homescreen-image">
			<div class="login-container">
				<h3>Find Event</h3>
				<g:if test="${error}">
					<div class="error">
						<span>Invalid name or password.</span>
					</div>
				</g:if>

				<g:form controller="events" action="loginToEvent">
					<g:field type="string" name="name" placeholder="Event name"/>
					<g:field type="password" name="password" placeholder="Password"/>
					<g:submitButton name="login" value="Find Event" class="button blue"/>
				</g:form>
			</div>
		</div>
	</body>
</html>
