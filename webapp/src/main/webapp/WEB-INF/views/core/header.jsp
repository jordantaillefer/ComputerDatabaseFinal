
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<div class="container nav navbar-cdb">
	<div class="brand-panel">
		<a class="navbar-brand" id="brand-cdb" href="dashboard?page=0&column=${ options.sort }&search=${options.search }&nbObject=${nbObjectPerPage}"> 
		Application - Computer Database 
		</a>
		<a href="dashboard?mylocale=en"><img alt="English"  class="picto-flag" src="<c:url value="/resources/img/flag-en.png"/>"></a>
		<a href="dashboard?mylocale=fr"><img alt="French"  class="picto-flag" src="<c:url value="/resources/img/flag-fr.png"/>"></a>
	</div>
	<div class="form-login-panel">
	  	<sec:authorize access="isAnonymous()"> 
		    <form id="header-form-login" method="POST" action="<c:url value='/login'/>" >
		    	<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
		        <div class="group">      
					      <input type="text" id="username" name="username" required>
					      <span class="highlight"></span>
					      <span class="bar"></span>
					      <label><spring:message code="login.username"/> </label>
					    </div> 
		        <div class="group">      
					      <input type="password" id="password" name="password" required>
					      <span class="highlight"></span>
					      <span class="bar"></span>
					      <label><spring:message code="login.password"/></label>
					    </div>
		        <button type="submit" class="button buttonBlue"><spring:message code="login.signin"/>
			    	<div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
				</button>
		    </form>
		    <a class="button buttonBlue" href="<c:url value="/addUser" />">Register</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		    <a class="button buttonBlue" href="<c:url value="/logout" />">Logout</a>
		</sec:authorize>
	</div>
</div>
