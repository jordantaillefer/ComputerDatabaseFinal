<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<!-- Bootstrap -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toaster.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/material.css" />" rel="stylesheet">
</head>
<body id="addComputer">
	<header class="navbar navbar-inverse navbar-fixed-top">
		<%@ include file="core/header.jsp"%>
	</header>

	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 box">
					<h1>Add Computer</h1>
					<form id="addComputerForm" action="addComputerAction"
						method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<fieldset>
							<div class="form-group">
								<label for="computerName">Computer name</label> <input
									type="text" name="name" class="form-control" id="computerName"
									placeholder="Computer name" required/>
							</div>
							<div class="form-group">
								<label for="introduced">Introduced date</label> <input
									type="date" name="introduced" class="form-control"
									id="introduced" placeholder="Introduced date"/>
							</div>
							<div class="form-group">
								<label for="discontinued">Discontinued date</label> <input
									type="date" name="discontinued" class="form-control"
									id="discontinued" placeholder="Discontinued date"/>
							</div>
							<div class="form-group">
								<label for="companyId">Company</label> <select
									class="form-control" name="companyId" id="companyId">
									<c:forEach items="${listCompanyDto}" var="companyDto">
										<option value="${companyDto.id }">${companyDto.name }</option>
									</c:forEach>
									<option value="0">--</option>
								</select>
							</div>
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" id="submitForm" value="Add" class="btn btn-primary" /> or <a
								href="dashboard.jsp" class="btn btn-default">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="core/footer.jsp"%>
	<script src="../resources/js/addComputer.js"></script>
</body>
</html>
