<html>
<head>
<title>Please Login</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet">

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="main-panel">
		<div class="login-panel">

			<form id="form-login" action="login" method="post">
				<div class="title-login">
					<span id="text-title-login"><spring:message code="login.title"/></span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" id="_csrf"
					value="${_csrf.token}" />${param.error}
				<c:if test="${param.error}">
					<div class="alert alert-error">Invalid username and password.
					</div>
				</c:if>
				<c:if test="${param.logout}">
					<div class="alert alert-success">You have been logged out.</div>
				</c:if>
				<div class="input-field">
					<input type="text" class="validate" name="username" required>
					<label for="username"><spring:message code="login.username"/></label>
				</div>
				<div class="input-field">
					<input type="password" class="validate" id="password" name="password" required>
					<label for="password"><spring:message code="login.password"/></label>
				</div>

				<div class="form-actions">
					<button id="submit" type="submit" class="waves-effect waves-light btn">
						<spring:message code="login.signin"/>
						<div class="ripples buttonRipples">
							<span class="ripplesCircle"></span>
						</div>
					</button>
				</div>
			</form>
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>
</body>
</html>