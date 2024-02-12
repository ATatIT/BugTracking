<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>ListProjectUser</h2>
	<table border="1">
			<tr>
				<th>UserId</th>
				<th>projectId</th>
				<th>AssignStatus</th>	
			</tr>
			
			<c:forEach items="${pu}" var="puser">
			
			<tr>
				<td>${puser.userId}</td>
				<td>${puser.projectId}</td>
				<td>${puser.assignStatus}</td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>