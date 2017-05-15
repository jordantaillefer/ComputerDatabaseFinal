<!DOCTYPE html>
<html>
	<head>
		<title>Computer Database</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!-- Bootstrap -->
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
		<link href="<c:url value="/resources/css/addComputer.css" />"
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
						<spring:message	code="dashboard.add_computer"/>
					</span>
				</div>
			</div>
			
			<div class="addComputer-main-panel">
				<div class="addComputer-form-panel">
					
					<form id="addComputerForm" action="addComputer"
							method="POST">
							<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<div class="title-addComputer">
							<span id="text-addComputer-login"><spring:message code="dashboard.add_computer"/></span>
						</div>
						<div class="group">
							<input type="text" id="name" name="name" required>
							<span class="highlight"></span> <span class="bar"></span> <label><spring:message code="dashboard.computer_name"/></label>
						</div>
						<div class="group">
							<input type="date" id="introduced" name="introduced" required>
							<span class="highlight"></span> <span class="bar"></span> <label><spring:message code="dashboard.computer_introduced"/></label>
						</div>
						<div class="group">
							<input type="date" id="discontinued" name="discontinued" required>
							<span class="highlight"></span> <span class="bar"></span> <label><spring:message code="dashboard.computer_discontinued"/></label>
						</div>
						<div class="group">
							<label for="companyId">Company</label> <select
								class="form-control" name="companyId" id="companyId">
								<c:forEach items="${listCompanyDto}" var="companyDto">
									<option value="${companyDto.id }">${companyDto.name }</option>
								</c:forEach>
								<option value="0">--</option>
							</select>
						</div>
						<div class="form-actions">
							<button type="submit" class="button buttonBlue">
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
	</body>
</html>