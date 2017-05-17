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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href="<c:url value="/resources/css/dashboardUser.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toaster.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/material.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


</head>
<body id="dashboard">
<!-- Always shows a header, even in smaller screens. -->
	<div class="panel-header">
		<div class="mdl-layout mdl-js-layout">
		  <header class="layout_header">
		    <div class="mdl-layout__header-row">
		      <span class="mdl-layout-title"> <a href="dashboard" >Computer Database</a></span>
		      <div class="mdl-layout-spacer"></div>
		      <div class="navigation mdl-navigation">
		        
		        <sec:authorize access="isAnonymous()"> 
		        	<a class="waves-effect waves-light btn" href="<c:url value="/addUser" />">Register</a>
		        <a class="waves-effect waves-light btn" href="<c:url value="/login" />">Login</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<a class=" waves-effect waves-light btn" href="<c:url value="/logout" />">Logout</a>
				</sec:authorize>
		      </div>
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
			  <li id="menu_dashboard" class="mdl-menu__item mdl-menu__item--full-bleed-divider"><i class="material-icons">dvr</i><span>Computer</span></li>
			  <li id="menu_dashboard_user" class="mdl-menu__item mdl-menu__item--full-bleed-divider"><i class="material-icons">account_circle</i><span>Users</span></li>
			</ul>
		</div>
	</div>
	<div class="card mdl-shadow--2dp">
		<div class="mdl-card__supporting-text">
			<h1 id="homeTitle">${ nbUserDto  }
				<spring:message code="dashboard.user_found" />
			</h1>
		</div>

		<div class="container">
			<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" id="tableDashboard">
				<thead>
					<tr>
						<th class="mdl-data-table__cell--non-numeric">Username (no multilingual, no sort)</th>
						<th class="mdl-data-table__cell--non-numeric">Role</th>
						<th class="mdl-data-table__cell--non-numeric">Enabled</th>
					</tr>
				</thead>
				<tbody id="results">
					<c:forEach items="${ users}" var="user">
						<tr>
							<td class="mdl-data-table__cell--non-numeric">${user.username }</td>
							<td class="mdl-data-table__cell--non-numeric">${user.role }</td>
							<td class="mdl-data-table__cell--non-numeric">${user.enabled }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</section>
	
	<div class="dashboard-fab-go-to-top">
		<button  class="btn-floating btn-large waves-effect waves-light"
		onclick="$('html,body').animate({scrollTop:0},'slow');return false;">
			<i class="material-icons">keyboard_arrow_up</i>
		</button>
	</div>
	<div class="dashboard-fab-go-to-bottom">
		<button  class="btn-floating btn-large waves-effect waves-light"
		onclick="$('html,body').animate({scrollTop: $(document).height()},'slow');return false;">
			<i class="material-icons">keyboard_arrow_down</i>
		</button>
	</div>
	<div class="dashboard-fab-add">
		<button id="button-add-user" class="btn-floating btn-large waves-effect waves-light">
		  <i class="material-icons">add</i>
		</button>
	</div>

	<footer class="navbar-fixed-bottom">
		<div class="footer-panel">
		</div>
	</footer> 
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/dashboardUser.js" />"></script>
	<script src="<c:url value="/resources/js/menu.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>
