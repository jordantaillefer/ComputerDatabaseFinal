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
<link href="<c:url value="/resources/css/materialize.min.css" />"
	rel="stylesheet">
<link href="/webapp/resources/css/material.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
	<div class="main-panel">
		<div class="add-panel">


			<form id="form-add" action="addUser" method="POST">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="title-add">
					<span id="text-title-add"><spring:message code="add.title" /></span>
				</div>
				<div class="input-field">
					<input type="text" id="username" name="username" required>
					<span class="highlight"></span> <span class="bar"></span> <label><spring:message
							code="addUser.username" /></label>
				</div>
				<div class="input-field">
					<input type="password" id="password" name="password" required>
					<span class="highlight"></span> <span class="bar"></span> <label><spring:message
							code="addUser.password" /></label>
				</div>
				<div class="input-field">
						<input type="checkbox" class="filled-in"  id="filled-in-box" name="enabled"/>
						 <label id="enable" for="filled-in-box"> Enabled </label>
				</div>
				<div class="form-actions">
					<button id="submit" type="submit"
						class="waves-effect waves-light btn">
						<div class="ripples buttonRipples">
							<span class="ripplesCircle"><spring:message
									code="add.btn_submit" /></span>
						</div>
					</button>
				</div>
			</form>
		</div>
	</div>
	<div class="fab-btn">
		<a href="/webapp/dashboard"
			class="btn-floating btn-large waves-effect waves-light "><i
			class="material-icons">home</i></a>
	</div>

	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/addUser.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>
</body>
</html>


