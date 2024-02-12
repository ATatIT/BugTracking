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
<h2>List Users</h2>
		<table border="1">
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>	
				<th>Password</th>
				<th>Gender</th>
				<th>ContactNum</th>
				<th>DOB</th>
				<th>Address</th>
				<th>State</th>
				<th>City</th>
				<th>Otp</th>
			</tr>
			
			<c:forEach items="${u}" var="user">
			
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.pass}</td>
				<td>${user.gender}</td>
				<td>${user.contact}</td>
				<td>${user.dob}</td>
				<td>${user.address}</td>
				<td>${user.state}</td>
				<td>${user.city}</td>
				<td>${user.otp}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>