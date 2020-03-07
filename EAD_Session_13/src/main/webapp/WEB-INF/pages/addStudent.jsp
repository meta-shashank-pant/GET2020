<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!doctype html>
<html lang="en">
  <head>
    <title>Add Student Details</title>
  </head>
  
  <body align="center">
	<h3 align="center">Add Students Details</h3>
	<div class="container" style="margin-top: 60px;margin-left: 32%;margin-right: 32%;" >
		<form:form modelAttribute="student" >
		 <form:errors />
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:input id="firstName"
					path="firstName" placeholder="Enter First Name" />
				 <form:errors path="firstName" /> 
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input id="lastName"
					path="lastName" placeholder="Enter Last Name" />
				 <form:errors path="lastName" /> 
			</div>
			<div class="form-group">
				<form:label path="fatherName">Father's name</form:label>
				<form:input id="fatherName"
					path="fatherName" placeholder="Enter father's Name" />
				 <form:errors path="fatherName" /> 
			</div>
			<div class="form-group">
				<form:label path="email">Email address</form:label>
				<form:input type ="email" id="email" path="email" placeholder="Enter email" />
				 <form:errors path="email" /> 
			</div>
			  <div class="form-group">
				<form:label path="classNo">Class</form:label>
				<form:input type="number" id="classNo" path="classNo"
					placeholder="Class" />
				<form:errors path="classNo"/>
			</div>
			<div class="form-group">
				<form:label path="age">AGE</form:label>
				<form:input type="number" id="age" path="age"
					placeholder="age" />
				<form:errors path="age" />
			</div> 


			<button type="submit">Submit</button> 
		</form:form>
	</div>
</body>
</html>