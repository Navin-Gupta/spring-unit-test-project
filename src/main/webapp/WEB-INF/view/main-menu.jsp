<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Hi, <security:authentication property="principal.username"/></h2>
<h2>Role(s) : <security:authentication property="principal.authorities"/></h2>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
	<input type="submit" value="Logout" />
</form:form>
<hr />
<h1>Employee Dash-board</h1>
<hr/>
<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/admin">Admin Portal</a>
</security:authorize>

<br>
<security:authorize access="hasRole('MANAGER')">
<a href="${pageContext.request.contextPath}/manager">Manager Portal</a>
</security:authorize>

</body>
</html>