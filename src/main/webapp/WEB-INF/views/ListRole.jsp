<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Role List</h2>
	${r.size()}
	<table border="1">
			<tr>
				<th>RoleName</th>
			</tr>
			
			<c:forEach items="${r}" var="role">
			
			<tr>
				<td>${role.roleName}</td>
			</tr>
			</c:forEach>
</body>
</html>