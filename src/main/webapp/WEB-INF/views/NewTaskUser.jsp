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
<h2>NewTaskUser</h2>
<form action="savetaskuser" method="post">
User:<select name="userId">
		<option>----Select User----</option>
		<c:forEach items="${userList}" var="user">
		<option value="${user.userId}">${user.firstName} ${user.lastName}</option>
		</c:forEach>
	 </select><br><br>
Task:<select name="taskId">
		<option>----Select TaskUser----</option>
		<c:forEach items="${taskList}" var="task">
		<option value="${task.taskId}">${task.title}</option>
		</c:forEach>
	   </select><br><br>
AssignStatus:<input type="text" name="assignStatus"/><br><br>
Status:<select name="statusId">
						<option>----ProjectStatus----</option>
						<c:forEach items="${projectStatusList}" var="projectstatus">
						<option value="${projectstatus.statusId}">${projectstatus.status}</option>
						</c:forEach>
					 </select><br><br>
UtilizedHours:<input type="text" name="utilizedHours"/><br><br>

<input type="submit" value="Add TaskUser"/>
</form>
</body>
</html>