<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<!-- Bootstrap -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="page" uri="/WEB-INF/pagination.tld"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toaster.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/material.css" />"
	rel="stylesheet">
	
<link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


</head>
<body id="dashboard">
	<header class="navbar navbar-inverse navbar-fixed-top">
		<%@ include file="core/header.jsp"%>

	</header>

	<section id="main">
		<div class="container">
			<h1 id="homeTitle"> Do we display number of Users ?
			</h1>

			<div id="actions" class="form-horizontal">
				<div class="pull-left form-inline">
					<form id="searchForm" action="dashboardUser" method="GET"
						class="form-inline">
						<input type="hidden" name="page" value="${ 0 }" /><input
							type="search" id="searchbox" name="search" class="form-control"
							placeholder="<spring:message code="dashboard.actual_options_search"/>" />
						<input type="submit" id="searchsubmit"
							value="<spring:message code="dashboard.actual_reset"/>"
							class="btn btn-primary" />
					</form>
					<%-- <a class="btn btn-danger btn-md"
						href="dashboard?page=${ 0 }&search="> <spring:message
							code="dashboard.actual_options" /></a>
					<c:if test="${fn:length(model.options) > 0 }">
						<p class="options">
							<span><spring:message code="dashboard.actual_search" /></span>
							<c:forEach items="${ model.options }" var="option">
								<span> ${option.key } value : ${option.value }</span>
							</c:forEach>
						</p>
					</c:if> --%>
				</div>
				<%-- <div class="pull-right">
					<a class="btn btn-success" id="addComputer" href="addComputer"><spring:message
							code="dashboard.add_computer" /></a> <a class="btn btn-default"
						id="editComputer" href="#" onclick="$.fn.toggleEditMode();"><spring:message
							code="dashboard.edit" /></a>
				</div> --%>
			</div>
		</div>

		<%-- <form id="deleteForm" action="deleteComputer" method="POST">
			<input type="hidden" name="${_csrf.parameterName}" id="_csrf"
				value="${_csrf.token}" /> <input type="hidden" name="nbObject"
				value="${ model.pageComputerDto.nbObjectPerPage }" /> <input
				type="hidden" name="page" value="${ model.pageComputerDto.page }" />
			<input type="hidden" name="column" value="${ model.options.column }" />
			<input type="hidden" name="search" value="${ model.options.search }" />
			<input type="hidden" name="selection" value="">
		</form> --%>

		<div class="container" style="margin-top: 10px;">
			<table class="table table-striped table-bordered" id="tableDashboard">
				<thead>
					<tr>
						<th>Username (no multilingual, no sort)</th>
						<th>Role</th>
						<th>Enabled</th>
					</tr>
				</thead>
				<tbody id="results">
					<c:forEach items="${ users}" var="user">
						<tr>
							<td>${user.username }</td>
							<td>${user.role }</td>
							<td>${user.enabled }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<span id="top-link-block" class="hidden fab-goto-top"> <span
		class="fab-content"
		onclick="$('html,body').animate({scrollTop:0},'slow');return false;">
			<i class="glyphicon glyphicon-chevron-up"></i>
	</span>
	</span>
	<span id="bottom-link-block" class="hidden fab-goto-bottom"> <span
		class="fab-content"
		onclick="$('html,body').animate({scrollTop: $(document).height()},'slow');return false;">
			<i class="glyphicon glyphicon-chevron-down"></i>
	</span>
	
	</span>
	<div class="dashboard-fab-add">
		<button id="button-add-user" class="btn-floating btn-large waves-effect waves-light red">
		  <i class="material-icons">add</i>
		</button>
	</div>

	<footer class="navbar-fixed-bottom">
		<%@ include file="core/footer.jsp"%>
		<%-- <div class="container text-center">
			<ul class="pagination">
				<page:link page="0" type="first" label="&laquo;"
					column="${model.options.column }"
					search="${ model.options.search }"
					nbObject="${ model.pageComputerDto.nbObjectPerPage }" />
				<page:link page="${ model.pageComputerDto.page-1 }" type="previous"
					label="&lt;" column="${model.options.column }"
					search="${ model.options.search }"
					nbObject="${ model.pageComputerDto.nbObjectPerPage }" />
				<page:pagination page="${ model.pageComputerDto.page }"
					maxPage="${ model.pageComputerDto.maxPage }"
					column="${model.options.column }"
					search="${ model.options.search }"
					nbObject="${ model.pageComputerDto.nbObjectPerPage }" />
				<page:link page="${ model.pageComputerDto.page+1 }" type="next"
					label="&gt;" column="${model.options.column }"
					search="${ model.options.search }"
					nbObject="${ model.pageComputerDto.nbObjectPerPage }" />
				<page:link page="${ model.pageComputerDto.maxPage }" type="last"
					label="&raquo;" column="${model.options.column }"
					search="${ model.options.search }"
					nbObject="${ model.pageComputerDto.nbObjectPerPage }" />
			</ul>

			<div class="pull-right" role="group">
				<ul class="pagination">
					<c:forEach items="${model.nbObjectAvailablePerPage}" var="nbObject">
						<li
							<c:if test="${ nbObject  == model.pageComputerDto.nbObjectPerPage}">
              <c:out value='class=active'/>
            </c:if>><a
							id="nbObject${ nbObject }" class="nbObject"
							href="dashboard?page=${0 }&nbObject=${ nbObject }&column=${ model.options.column }&search=${model.options.search}">${ nbObject }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div> --%>
	</footer>
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/dashboardUser.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>
