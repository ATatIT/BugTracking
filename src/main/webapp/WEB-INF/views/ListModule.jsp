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
<h2>List Module</h2>
	${m.size()}
	<table border="1">
			<table border="1">
			<tr>
				<th>ProjectId</th>
				<th>Description</th>
				<th>Status</th>	
				<th>DocURL</th>
				<th>EstimatedHours</th>
				<th>TotalUtilizedHours</th>
			</tr>
			
			<c:forEach items="${m}" var="module">
			
			<tr>
				<td>${module.projectId}</td>
				<td>${module.description}</td>
				<td>${module.status}</td>
				<td>${module.docURL}</td>
				<td>${module.estimatedHours}</td>
				<td>${module.totalUtilizedHours}</td>
			</tr>
			</c:forEach>
		</table>

</body>
</html>