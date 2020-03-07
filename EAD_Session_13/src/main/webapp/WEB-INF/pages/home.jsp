<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
	<h2 align="center">${welcomeMessage}</h2>
		<div align = "left"><a href="logout" id="logout"> Logout </a><br></div>
		<div align = "center">
			<a href="/addStudent" id="stuDetail"> Add Student Details </a> <br>
			<a href="/showStudent" id="showStudents"> Student List </a><br>
		</div>
	</body>
</html>
