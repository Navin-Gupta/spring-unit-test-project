<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>User login here...</h2>

<form:form action="${pageContext.request.contextPath}/checkuser" method="POST">

	<core:if test="${param.error != null }">
		<i>Sorry! You entered invalid credentials</i>
	</core:if>
	
	<core:if test="${param.logout != null }">
		<i>You have been logged out</i>
	</core:if>

<%--
     explicit suuport for CSRF token in plain HTML form 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
--%>	
	<br><br>
	Enter Login Name	<input type="text" name="username" />
	<br><br>
	Enter Password		<input type="password" name="password" />
	<br><br>
	<input type="submit" value="Sign In" />

</form:form>

</body>
</html>