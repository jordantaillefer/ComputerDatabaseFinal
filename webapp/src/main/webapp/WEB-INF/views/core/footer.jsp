
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty toast}">
	<div class="toaster">
		<div id="snackbar"
			<c:if test="${not empty toast and not empty toast.sentenceType}" >
				<c:out value='class=${toast.sentenceType } '/>
		</c:if>>
			<c:if test="${not empty toast and not empty toast.sentenceType}">
				<c:if test="${toast.sentenceType == 'success'}">
					<span class="glyphicon glyphicon-ok"></span>
				</c:if>
				<c:if test="${toast.sentenceType == 'error'}">
					<span class="glyphicon glyphicon-remove"></span>
				</c:if>
			</c:if>
			

			<c:if test="${not empty toast and not empty toast.sentence}">
				<span id="toastSentence"><c:out value="${toast.sentence }" /></span>
			</c:if>
		</div>
		<script type="text/javascript">
			var x = document.getElementById("snackbar")
			x.className = x.className + " show"
			setTimeout(function() {
				x.className = x.className.replace(" show", "");
			}, 3000);
		</script>
	</div>
</c:if>