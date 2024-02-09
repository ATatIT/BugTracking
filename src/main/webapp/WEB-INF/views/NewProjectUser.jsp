<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>ProjectUser</h2>
<form action="/saveprojectuser" method="post"><br><br>
UserId: <input type="text" name="userID"/><br><br>
ProjectId: <input type="text" name="projectId"/><br><br>
AssignStatus: <input type="text" name="assignStatus"/><br><br>

<input type="submit" value="Add ProjectUser"/>
</form>
</body>
</html>