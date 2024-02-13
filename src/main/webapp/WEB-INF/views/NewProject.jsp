<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project</title>
</head>
<body>
<form action="saveproject" method="post">
	ProjectTitle :<input type="text" name="projecttitle" /><br><br>
	Description :<input type="text" name="description" /><br><br>
	ProjectStatus :<select name="projectStatusId">
						<option>----ProjectStatus----</option>
						<c:forEach items="${projectStatuList}" var="projectstatus">
						<option value="${projectstatus.statusId}">${projectstatus.status}</option>
						</c:forEach>
					 </select><br><br> 
	DocURL : <input type="text" name="docURL" /><br><br>
	EstimatedHours : <input type="text" name="estimatedHours" /><br><br>
	TotalUtilizedHous :	<input type="text" name="totalUtilizedHours" /><br><br>
	ProjectStartDate : <input type="text" name="projectStartDate" /><br><br>
	ProjectCompletionDate : <input type="text" name="projectCompletionDate" /><br><br>
	
	<input type="submit" value="Add Project"/>
</form>
</body>
</html>