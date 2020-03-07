<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<style>
div {
	text-align: center;
}

p {
	margin: auto;
	text-align: center;
}

table {
	margin: auto;
}

td, th {
	padding: 20px;
}
</style>

<title>students Data</title>
</head>

<body>

	<div align="center">
		<h1>Student Details</h1>
		<br>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Student's Email</th>
				<th>Student's Class</th>
				<th>Student's Age</th>
			</tr>

			<c:forEach items="${studentList}" var="studentsList">
				<tr>
					<td>${studentsList.getFirstName()}</td>
					<td>${studentsList.getLastName()}</td>
					<td>${studentsList.getFatherName()}</td>
					<td>${studentsList.getEmail()}</td>
					<td>${studentsList.getClassNo()}</td>
					<td>${studentsList.getAge()}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>

</html>
