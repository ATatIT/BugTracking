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
<h2>Modules</h2>
<form action="savemodule" method="post">
ModuleName:<input type="text" name="moduleName" /><br><br>
Project:<select name="projectId">
			<option value="-1">----Select Project----</option>
			<c:forEach items="${projectList}" var="project">
			<option value="${project.projectId}">${project.projecttitle}</option>
			</c:forEach>
		  </select> <br><br>
Status:<select name="status">
						<option>----ProjectStatus----</option>
						<c:forEach items="${projectStatusList}" var="projectstatus">
						<option value="${projectstatus.statusId}">${projectstatus.status}</option>
						</c:forEach>
					 </select><br><br><br><br>
Description:<input type="text" name="description" /><br><br>
DocURL:<input type="text" name="docURL" /><br><br>
EstimatedHours:<input type="text" name="estimatedHours" /><br><br>
TotalUtilizedHours:<input type="text" name="totalUtilizedHours" /><br><br>

<input type="submit" value="Add Module"/>
</form>
</body>
</html>