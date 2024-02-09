<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Task</h2>
<form action="savetask" method="post">
moduleId:<input type="text" name="moduleId" /><br><br>
projectId:<input type="text" name="projectId" /><br><br>
status:<input type="text" name="status" /><br><br>
Title:<input type="text" name="title" /><br><br>
DocURL:<input type="text" name="docURL" /><br><br>
Description:<input type="text" name="description" /><br><br>
EstimatedHours:<input type="text" name="estimatedHours" /><br><br>
TotalUtilizedHours:<input type="text" name="totalUtilizedHours" /><br><br>

<input type="submit" value="Add Task"/>
</form>
</body>
</html>