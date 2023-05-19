<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Students</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/files/css/style.css" />
</head>
<body>
	<div class="navbar">
		<a href="./">HomePage</a><br/>
		<a href="./addStudent">Add New Students</a><br/>
		<a href="./listStudents">Students List</a><br/>
		<a href="./addCourse">Add New Courses</a><br/>
		<a href="./listCourses">Courses List</a><br/>
		<a href="./addResult">Add New Results</a><br/>
		<a href="./listResults">Results List</a>
	</div>
	
	<div class="appname">
		Student Result Management Application
	</div>
	
	<div class="main">
		<h4>Add New Students
			<c:if test="${not empty success}">
				&nbsp;-&nbsp;&nbsp;<span class="successMessage">${success}</span>
			</c:if>
			<c:if test="${not empty error}">
				&nbsp;-&nbsp;&nbsp;<span class="errorMessage">${error}</span>
			</c:if>
		</h4>
		<hr/>
		<br/>
		<table>
			<form:form modelAttribute="student" action="addStudent">
			<tr><td>First Name</td><td><form:input style="margin:10px" required="true" path="firstName"/> 
			<form:errors path="firstName" cssStyle="color:red"></form:errors></td></tr>
			<tr><td>Family Name</td><td><form:input style="margin:10px" required="true" path="familyName"/> 
			<form:errors path="familyName" cssStyle="color:red"></form:errors></td></tr>
			<tr><td>DOB</td><td><form:input type="date" style="margin:10px" required="true" path="dob"/>
			<form:errors path="dob" cssStyle="color:red"></form:errors></td></tr>
			<tr><td>Email</td><td><form:input style="margin:10px" required="true" path="email"/>
			<form:errors path="email" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><input type="submit" style="margin-top:15px" value="Submit"></td></tr>
			</form:form>
		</table>
	</div>
</body>
</html>