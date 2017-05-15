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

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="main-panel">
		<div class="add-panel">

			<form id="form-add" action="editComputer" method="post">
				<div class="title-add">
					<span id="text-title-add">Edit : ${ computerToEdit.name } </span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" id="_csrf"
					value="${_csrf.token}" /> <input type="hidden"
					value="${ computerToEdit.id }" name="id" id="id" />
				<div class="input-field">
					<input type="text" name="name" id="name" value="${ computerToEdit.name }"> 
						<label for="name">Computer name</label>
				</div>
				<div class="input-field">
					<input type="text" class=" datepicker " id="introduced" name="introduced" value="${ computerToEdit.introduced }">
					<label for="introduced">Date Introduced</label>
				</div>
				<div class="input-field">
					<input type="text" class="datepicker" id="discontinued" name="discontinued" value="${ computerToEdit.discontinued }">
					<label for="discontinued">Date Discontinued</label>
				</div>
				<div class="input-field">
					<select name="companyId" id="companyId">
						<c:forEach items="${listCompanyDto}" var="companyDto">
							<option value="${companyDto.id }"
								<c:if test="${ companyDto.id  == computerToEdit.companyId}"> 
                     <c:out value="selected"/>
                   </c:if>>${ companyDto.name }</option>
						</c:forEach>
					</select> <label>Company</label>
				</div>
				<div class="form-actions">
					<button id="submit" type="submit"
						class="waves-effect waves-light btn">
						<div class="ripples buttonRipples">
							<span class="ripplesCircle">Send</span>
						</div>
					</button>
				</div>
			</form>
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/editComputer.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/init.js" />"></script>
</body>
</html>

