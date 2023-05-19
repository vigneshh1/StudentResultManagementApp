<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
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
		Welcome to the Portal of Viewing / Managing the Student Results.<br/><br/>Please select the appropriate action you wish to perform from the left navigation bar.
	</div>
</body>
</html>