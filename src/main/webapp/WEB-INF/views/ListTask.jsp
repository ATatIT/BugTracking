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
<h2>List Tasks</h2>
	${t.size()}
	<table border="1">
			<tr>
				<th>ModuleId</th>
				<th>ProjectId</th>
				<th>Status</th>	
				<th>Title</th>
				<th>Description</th>
				<th>DocUrl</th>
				<th>EstimatedHours</th>
				<th>TotalUtilizedHours</th>
			</tr>
			
			<c:forEach items="${t}" var="task">
			
			<tr>
				<td>${task.moduleId}</td>
				<td>${task.projectId}</td>
				<td>${task.status}</td>
				<td>${task.title}</td>
				<td>${task.description}</td>
				<td>${task.docURL}</td>
				<td>${task.estimatedHours}</td>
				<td>${task.totalUtilizedHours}</td>
			</tr>
			</c:forEach>
</body>
</html>