<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page isELIgnored="false" %>
<html>
<body>
<<<<<<< HEAD
=======

	<!-- Welcome Text -->
>>>>>>> master
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/logout" var="logoutUrl" />
<<<<<<< HEAD
=======
	
	<!-- Logout Form -->
>>>>>>> master
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
<<<<<<< HEAD
=======
	
	<!-- Logout Script --> 
>>>>>>> master
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
<<<<<<< HEAD

=======
	
	<!-- Content Display -->
>>>>>>> master
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

</body>
</html>