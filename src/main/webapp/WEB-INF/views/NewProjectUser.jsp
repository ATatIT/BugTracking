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
<h2>ProjectUser</h2>
<form action="/saveprojectuser" method="post"><br><br>
User: <select name="userId">
		<option>----Select User----</option>
		<c:forEach items="${userList}" var="user">
		<option value="${user.userId}">${user.firstName} ${user.lastName}</option>
		</c:forEach>
	 </select><br><br>
Project: <select name="projectId">
			<option value="-1">----Select Project----</option>
			<c:forEach items="${projectList}" var="project">
			<option value="${project.projectId}">${project.projecttitle}</option>
			</c:forEach>
		   </select> <br><br>
AssignStatus: <input type="text" name="assignStatus"/><br><br>

<input type="submit" value="Add ProjectUser"/>
</form>
</body>
</html>