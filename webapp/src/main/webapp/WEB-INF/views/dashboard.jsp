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

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toaster.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/material.min.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


</head>
<body id="dashboard">
<!-- Always shows a header, even in smaller screens. -->
	<div class="panel-header">
	<div class="mdl-layout mdl-js-layout">
	  <header class="layout_header">
	    <div class="mdl-layout__header-row">
	      <span class="mdl-layout-title"> <a href="dashboard" >Computer Database</a></span>
	      <form id="search-form" action="#">
	      		<label class="mdl-button mdl-js-button mdl-button--icon">
				  <i class="material-icons">search</i>
				</label>
			   <div class="mdl-textfield mdl-js-textfield">
			    <input class="mdl-textfield__input" type="text" id="sample1">
			    <label class="mdl-textfield__label" for="sample1">Search</label>
			  </div>

			</form>
	      <div class="mdl-layout-spacer"></div>
	      <nav class="mdl-navigation mdl-layout--large-screen-only">
	      
	      	
	      </nav>
	    </div>
	  </header>
	</div>
</div>
	<section id="main">
	<div class="sidebar">
		<div class="panel-icons">
		<a href="dashboard?mylocale=en"><img alt="English"  class="picto-flag" src="<c:url value="/resources/img/flag-en.png"/>"></a>
		<a href="dashboard?mylocale=fr"><img alt="French"  class="picto-flag" src="<c:url value="/resources/img/flag-fr.png"/>"></a>
		</div>
		<div class="menu">
			<ul class="dashboard-menu">
			  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider"><i class="material-icons">dvr</i><span>Computer</span></li>
			  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider"><i class="material-icons">work</i><span>Login</span></li>
			  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider"><i class="material-icons">account_circle</i><span>Users</span></li>
			</ul>
		</div>
	</div>
	<div class="card mdl-shadow--2dp">
		<div class="mdl-card__supporting-text">
		<div class="container">
			<h1 id="homeTitle">${ nbComputerDto }
				<spring:message code="dashboard.computer_found" />
			</h1>

			<%-- <div id="actions" class="form-horizontal">
				<div class="pull-left form-inline">
					<form id="searchForm" action="dashboard" method="GET"
						class="form-inline">
						<input type="hidden" name="page" value="${ 0 }" /><input
							type="hidden" name="nbObject"
							value="${ model.pageComputerDto.nbObjectPerPage }" /> <input
							type="hidden" name="column" value="${ model.options.column }" /><input
							type="search" id="searchbox" name="search" class="form-control"
							placeholder="<spring:message code="dashboard.actual_options_search"/>" />
						<input type="submit" id="searchsubmit"
							value="<spring:message code="dashboard.actual_reset"/>"
							class="btn btn-primary" />
					</form>
					<a class="btn btn-danger btn-md"
						href="dashboard?page=${ 0 }&column=&search=&nbObject=10"> <spring:message
							code="dashboard.actual_options" /></a>
					<c:if test="${fn:length(model.options) > 0 }">
						<p class="options">
							<span><spring:message code="dashboard.actual_search" /></span>
							<c:forEach items="${ model.options }" var="option">
								<span> ${option.key } value : ${option.value }</span>
							</c:forEach>
						</p>
					</c:if>
				</div>
				<div class="pull-right">
					<a class="btn btn-success" id="addComputer" href="addComputer"><spring:message
							code="dashboard.add_computer" /></a> <a class="btn btn-default"
						id="editComputer" href="#" onclick="$.fn.toggleEditMode();"><spring:message
							code="dashboard.edit" /></a>
				</div>
			</div> --%>
		</div>

		<form id="deleteForm" action="deleteComputer" method="POST">
			<input type="hidden" name="${_csrf.parameterName}" id="_csrf"
				value="${_csrf.token}" /> <input type="hidden" name="nbObject"
				value="${ model.pageComputerDto.nbObjectPerPage }" /> <input
				type="hidden" name="page" value="${ model.pageComputerDto.page }" />
			<input type="hidden" name="column" value="${ model.options.column }" />
			<input type="hidden" name="search" value="${ model.options.search }" />
			<input type="hidden" name="selection" value="">
		</form>
		
		

		<div class="container" style="margin-top: 10px;">
			<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" id="tableDashboard">
				<thead>
					<tr>

						<th class="sortCol mdl-data-table__cell--non-numeric mdl-data-table__header--sorted-ascending"><a
							href="dashboard?column=name&page=${ model.pageComputerDto.page }&nbObject=${model.pageComputerDto.nbObjectPerPage}&search=${model.options.search}"><spring:message
									code="dashboard.computer_name" /></a></th>
						<th class="sortCol  mdl-data-table__cell--non-numeric"><a
							href="dashboard?column=introduced&page=${ model.pageComputerDto.page }&nbObject=${model.pageComputerDto.nbObjectPerPage}&search=${model.options.search}"><spring:message
									code="dashboard.computer_introduced" /></a></th>
						<th class="sortCol  mdl-data-table__cell--non-numeric"><a
							href="dashboard?column=discontinued&page=${ model.pageComputerDto.page }&nbObject=${model.pageComputerDto.nbObjectPerPage}&search=${model.options.search}"><spring:message
									code="dashboard.computer_discontinued" /></a></th>
						<th class="sortCol  mdl-data-table__cell--non-numeric"><a
							href="dashboard?column=co.name&page=${ model.pageComputerDto.page }&nbObject=${model.pageComputerDto.nbObjectPerPage}&search=${model.options.search}"><spring:message
									code="dashboard.company_name" /></a></th>

					</tr>
				</thead>
				<tbody id="results">
					<c:forEach items="${ model.listComputerDto}" var="computerDto">
						<tr class="rowComputer" id="${ computerDto.id }">
							
							<td class="labelName  mdl-data-table__cell--non-numeric">
								<div class="delete-panel">
									<%-- <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-${ computerDto.id }">
										<input type="checkbox" id="checkbox-${ computerDto.id }" class="cb mdl-checkbox__input" name="cb"
										value="${ computerDto.id }">
									</label> --%>
									<button id="button-delete-computer" class="mdl-button mdl-js-button"
									onclick="$.fn.toggleEditMode();">
									  <i class="material-icons">delete</i>
									</button>
									<button id="${ computerDto.id }" class="mdl-button mdl-js-button button-edit-computer">
									  <i class="material-icons">edit</i>
									</button>
									
								</div>
								<div class="delete-checkbox-panel">
									
								</div>
								<span>${ computerDto.name }</span>
							</td>
							<td class="labelIntroduced  mdl-data-table__cell--non-numeric">${ computerDto.introduced }</td>
							<td class="labelDiscontinued  mdl-data-table__cell--non-numeric">${ computerDto.discontinued }</td>
							<td class="mdl-data-table__cell--non-numeric" >${ computerDto.companyName }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
			</div>
		</div>
	</section>
	<div class="dashboard-fab-go-to-top">
		<button  class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored"
		onclick="$('html,body').animate({scrollTop:0},'slow');return false;">
			<i class="material-icons">keyboard_arrow_up</i>
		</button>
	</div>
	<div class="dashboard-fab-go-to-bottom">
		<button  class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored"
		onclick="$('html,body').animate({scrollTop: $(document).height()},'slow');return false;">
			<i class="material-icons">keyboard_arrow_down</i>
		</button>
	</div>
	<div class="dashboard-fab-add">
		<button id="button-add-computer" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
		  <i class="material-icons">add</i>
		</button>
	</div>
	<div class="dashboard-fab-delete">
		<button id="button-delete-computer" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
		  <i class="material-icons">delete</i>
		</button>
	</div>
	

	 <footer class="navbar-fixed-bottom">
		<%@ include file="core/footer.jsp"%>
		<div class="footer-panel">
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

			<div class="number-page-panel" role="group">
				<ul class="pagination">
					<c:forEach items="${model.nbObjectAvailablePerPage}" var="nbObject">
						<li
							<c:if test="${ nbObject  == model.pageComputerDto.nbObjectPerPage}">
              <c:out value='class=active'/>
            </c:if>><a
							id="nbObject${ nbObject }" class='mini-fab mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab'
							href="dashboard?page=${0 }&nbObject=${ nbObject }&column=${ model.options.column }&search=${model.options.search}">${ nbObject }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</footer> 
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/dashboard.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
	<script src="<c:url value="/resources/js/material.min.js" />"></script>
</body>
</html>
