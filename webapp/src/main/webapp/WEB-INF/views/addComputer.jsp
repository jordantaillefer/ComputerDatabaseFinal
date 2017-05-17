<html>
<head>
<title>Please add</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/resources/css/addComputer.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet">
<link href="/webapp/resources/css/material.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="main-panel">
		<div class="add-panel">

			<form id="form-add" action="addComputer" method="post">
				<div class="title-add">
					<span id="text-title-add"><spring:message code="add.title"/></span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" id="_csrf"
					value="${_csrf.token}" />
				<div class="input-field">
					<input type="text" name="name" id="name"> <label
						for="name"><spring:message code="add.computer_name"/></label>
				</div>
				<div class="input-field">
					<input type="text" class=" datepicker " id="introduced"
						name="introduced"> <label for="introduced"><spring:message code="add.computer_date_introduced"/>  ( date > 1970 & < 2038 ) </label>
				</div>
				<div class="input-field">
					<input type="text" class="datepicker" id="discontinued"
						name="discontinued"> <label for="discontinued"><spring:message code="add.computer_date_discontinued"/> ( date > 1970 & < 2038 ) </label>
				</div>
				<div class="input-field">
					<select name="companyId" id="companyId">
						<option value="0"><spring:message code="add.computer_no_company"/></option>
						<c:forEach items="${listCompanyDto}" var="companyDto">
							<option value="${companyDto.id }">${companyDto.name }</option>
						</c:forEach>
					</select> <label><spring:message code="add.company"/></label>
				</div>
				<div class="form-actions">
					<button id="submit" type="submit" 
						class="waves-effect waves-light btn">
						<div class="ripples buttonRipples">
							<span class="ripplesCircle"><spring:message code="add.btn_submit"/></span>
						</div>
					</button>
				</div>
			</form>
		</div>
		<div class="fab-btn">
			<a href="/webapp/dashboard"
		class="btn-floating btn-large waves-effect waves-light "><i
		class="material-icons">home</i></a>
		</div>
	</div>
	
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/addComputer.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>
</body>
</html>