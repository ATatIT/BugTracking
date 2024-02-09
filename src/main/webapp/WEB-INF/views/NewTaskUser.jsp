<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>NewTaskUser</h2>
<form action="savetaskuser" method="post">
UserID:<input type="text" name="userID"/><br><br>
TaskId:<input type="text" name="taskId"/><br><br>
AssignStatus:<input type="text" name="assignStatus"/><br><br>
StatusId:<input type="text" name="statusId"/><br><br>
UtilizedHours:<input type="text" name="utilizedHours"/><br><br>

<input type="submit" value="Add TaskUser"/>
</form>
</body>
</html>