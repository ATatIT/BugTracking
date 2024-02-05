<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup</title>
</head>
<body>
	<h2>Sign up</h2>
	
	<form action="saveuser" method="post">
	
		FirstName:<input type="text" name="firstname" /><br><br>
		LastName:<input type="text" name="lastname" /><br><br>
		Email:<input type="email" name="email" /><br><br>
		Password:<input type="password" name="pass" /><br><br>
		
		<input type="submit" value="SignUp"/>
	</form>
</body>
</html>