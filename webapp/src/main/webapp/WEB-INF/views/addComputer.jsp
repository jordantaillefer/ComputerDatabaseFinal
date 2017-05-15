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
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/material.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/material.min.css" />"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">



</head>

<body>

	<div class="row">
		<form class="col s12">
			<div class="row">
				<div class="input-field col s12">
					<input placeholder="Computer Name" id="name" type="text"
						class="validate"> <label for="name">Computer Name</label>
				</div>
				<div class="input-field col s12">
					<input id="introduced" type="date" class="validate"> <label
						for="introduced">Date introduced</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="discontinued" type="date" class="validate"> <label
						for="discontinued">Date discontinued</label>
				</div>
			</div>
			<div class="input-field col s12">
				<select name="companyId" id="companyId">
					<option value="0">--</option>
					<c:forEach items="${listCompanyDto}" var="companyDto">
						<option value="${companyDto.id }">${companyDto.name }</option>
					</c:forEach>
				</select>
			</div>
		</form>
	</div>

	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/addComputer.js" />"></script>
	<script src="<c:url value="/resources/js/dashboard.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
	<script src="<c:url value="/resources/js/material.min.js" />"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</body>
</html>