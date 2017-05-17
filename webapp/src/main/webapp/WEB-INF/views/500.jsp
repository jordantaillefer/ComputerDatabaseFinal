<!DOCTYPE html>
<html>
<head>
    <title>Computer Database</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link href="<c:url value="/resources/css/material.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/exception.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

    <section id="main">
        <div class="container">
        	<div class="card panel-exception">
        		<div class="header-panel"><span>403 Internal error</span></div>
        		<div class="content-panel">
		        	<a class="navbar-brand" href="<c:url value="/dashboard" />"> Back to the dashboard <i class="material-icons right">exit_to_app</i> </a>
	            </div>
        	</div>
            
        </div>
    </section>

	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/dashboard.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.min.js" />"></script>
	<script src="<c:url value="/resources/js/material.min.js" />"></script>

</body>
</html>
