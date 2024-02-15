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
<h2>List ProjectStatus</h2>

	<table border="1">
			<tr>
				<th>StatusId</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${s}" var="pstatus">
			
			<tr>
				<td>${pstatus.statusId}</td>
				<td>${pstatus.status}</td>
				<td><a href="deleteprojectstatus?statusId=${pstatus.statusId}">Delete</a></td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>