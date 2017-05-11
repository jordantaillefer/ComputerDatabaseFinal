<!DOCTYPE html>
<html>
<head>
  <title>Computer Database</title>
  
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toaster.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/material.css" />" rel="stylesheet">
</head>
<body id="editComputer">
<header class="navbar navbar-inverse navbar-fixed-top">

  <div class="container">
    <%@ include file="core/header.jsp" %>
  </div>
</header>
<section id="main">
  <div class="container">
    <div class="row">
      <div class="col-xs-8 col-xs-offset-2 box">
        <div class="label label-default pull-right">id: ${ computerToEdit.id }</div>
        <h1>Edit Computer</h1>

        <form id="editComputerForm" action="editComputer" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" id="_csrf"
						value="${_csrf.token}" />
          <input type="hidden" value="${ computerToEdit.id }" name="id" id="id"/>
          <fieldset>
            <div class="form-group">
              <label for="name">Computer name</label> <input
              type="text" class="form-control" name="name" id="computerName"
              oninvalid="setCustomValidity('The name must be composed by char and at least 3')"
              value="${ computerToEdit.name }" placeholder="Computer name" required>
            </div>
            <div class="form-group">
              <label for="introduced">Introduced date</label> <input
              type="date" class="form-control" name="introduced" id="introduced"
              value="${ computerToEdit.introduced }"
              placeholder="Introduced date">
            </div>
            <div class="form-group">
              <label for="discontinued">Discontinued date</label> <input
              type="date" class="form-control" id="discontinued" name="discontinued"
              value="${ computerToEdit.discontinued }"
              placeholder="Discontinued date">
            </div>
            <div class="form-group">
              <label for="companyId">Company</label> <select name="companyId"
                                                             class="form-control" id="companyId">
              <c:forEach items="${listCompanyDto}" var="companyDto">
                <option value="${companyDto.id }"
                  <c:if test="${ companyDto.id  == computerToEdit.companyId}">
                    <c:out value="selected"/>
                  </c:if>>
                    ${companyDto.name }</option>
              </c:forEach>
            </select>
            </div>
          </fieldset>

          <div class="actions pull-right">
            <input type="submit" id="submitForm" value="Edit" class="btn btn-primary">
            or <a href="dashboard.html" class="btn btn-default">Cancel</a>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
<%@ include file="core/footer.jsp" %>
</body>
</html>
