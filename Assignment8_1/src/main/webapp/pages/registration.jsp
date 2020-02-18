<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/registration" var="userActionUrl" />


	<form:form modelAttribute="student" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		<div class="form-group">
			<form:label path="first_name">First Name</form:label>
			<form:input path="first_name" type="text" class="form-control"
				id="exampleInputName1" placeholder="First Name" />
			<form:errors path="first_name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="last_name">Last Name</form:label>
			<form:input path="last_name" type="text" class="form-control"
				id="exampleInputName2" placeholder="Last Name" />
			<form:errors path="last_name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="father_name">Father Name</form:label>
			<form:input path="father_name" type="text" class="form-control"
				id="exampleInputName3" placeholder="Father Name" />
			<form:errors path="father_name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="email">Email address</form:label>
			<form:input path="email" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Email" />
			<form:errors path="email" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="s_class">Class</form:label>
			<form:input path="s_class" type="number" class="form-control"
				id="exampleInputNumber1" placeholder="Class" />
			<form:errors path="s_class" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:input path="age" type="number" class="form-control"
				id="exampleInputNumber2" placeholder="Age" />
			<form:errors path="age" cssClass="text-danger" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>

<%@include file="../includes/footer.jsp" %>