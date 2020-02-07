<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <!--  <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   <%@page import="students.StudentDetails" %>-->
   <%@page import="java.util.*" %>
   <%@page import="javax.servlet.http.*" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


</head>
<body>
<%
if(session.getAttribute("firstname")==null){
	response.sendRedirect("student1.jsp");
}

%>

<form id="displayForm" action="ads">
<label><input type="submit" value="show details"></label>
<label><input type="button" value="edit details" onclick="window.location.href='student4.jsp' "></label>
<label><input type="button" value="filter details" onclick="window.location.href='student5.jsp' "></label>

</form>

</body>
</html>