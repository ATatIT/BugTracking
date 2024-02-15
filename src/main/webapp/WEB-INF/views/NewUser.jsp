<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
<form action="saveuser" method="post">
	
		FirstName:<input type="text" name="firstName" /><br><br>
		LastName:<input type="text" name="lastName" /><br><br>
		Email:<input type="email" name="email" /><br><br>
		Password:<input type="password" name="pass" /><br><br>
		Gender :Male<input type="radio" name="gender" checked="checked"/> Female<input type="radio" name="gender"/><br><br> 
		DOB    :<input type="date" name="dob" /><br><br>
		Contact:<input type="text" name="contact" /><br><br>
		Address:<textarea rows="2" cols="20" name="address"></textarea><br><br>
		City   :<input type="text" name="city" /><br><br>
		State  :<input type="text" name="state" /><br><br>
		OTP    :<input type="text" name="otp" /><br><br>
		Role   :<select name="roleId">
					<option value="-1">----Select Role----</option>
					<c:forEach items="${roleList}" var="role" >
					<option value="${role.roleId}">${role.roleName}</option>
					</c:forEach>
				</select><br><br>
		
		<input type="submit" value="Add User"/>
	</form>

</body>
</html>