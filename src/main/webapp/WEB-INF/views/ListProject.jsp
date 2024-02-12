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
<h2>List Project</h2>
	${p.size()}
		<table border="1">
			<tr>
				<th>ProjectTitle</th>
				<th>Description</th>
				<th>ProjectStatusId</th>	
				<th>DocURL</th>
				<th>EstimatedHours</th>
				<th>TotalUtilizedHours</th>
				<th>ProjectStartDate</th>
				<th>ProjectCompletionDate</th>
			</tr>
			
			<c:forEach items="${p}" var="project">
			
			<tr>
				<td>${project.projecttitle}</td>
				<td>${project.description}</td>
				<td>${project.projectStatusId}</td>
				<td>${project.docURL}</td>
				<td>${project.estimatedHours}</td>
				<td>${project.totalUtilizedHours}</td>
				<td>${project.projectStartDate}</td>
				<td>${project.projectCompletionDate}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>