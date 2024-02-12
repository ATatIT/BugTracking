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
				<th>Status</th>
			</tr>
			
			<c:forEach items="${s}" var="pstatus">
			
			<tr>
				<td>${pstatus.status}</td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>