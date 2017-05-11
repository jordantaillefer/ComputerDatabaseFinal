<!DOCTYPE html>
<html>
	<head>
		<title>Computer Database</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!-- Bootstrap -->
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
		<link href="<c:url value="/resources/css/addUser.css" />"
			rel="stylesheet">
		<link href="<c:url value="/resources/css/reset.css" />"
			rel="stylesheet">
		<link href="<c:url value="/resources/css/material.css" />"
			rel="stylesheet">
	
	</head>
	
	<body>
		<div class="addComputer-panel">
			<div class="title-panel">
				<div class="addComputer-overlay"></div>
				<div class="addComputer-title-panel">
					<span class="addComputer-title">
						<spring:message	code="addUser.title"/>
					</span>
				</div>
			</div>
			
			<div class="addComputer-main-panel">
				<div class="addComputer-form-panel">
					
					<form id="addUserForm" action="addUser"
							method="POST">
							<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<div class="title-addComputer">
							<span id="text-addComputer-login"><spring:message code="addUser.title"/></span>
						</div>
						<div class="group">
							<input type="text" id="username" name="username" required>
							<span class="highlight"></span> <span class="bar"></span> <label><spring:message code="addUser.username"/></label>
						</div>
						<div class="group">
							<input type="password" id="password" name="password" required>
							<span class="highlight"></span> <span class="bar"></span> <label><spring:message code="addUser.password"/></label>
						</div>
						<div class="form-actions">
							<button type="button" id="action-add-user" class="button buttonBlue">
								<spring:message code="login.signin"/>
								<div class="ripples buttonRipples">
									<span class="ripplesCircle"></span>
								</div>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/addUser.js" />"></script>
	</body>
	
</html>