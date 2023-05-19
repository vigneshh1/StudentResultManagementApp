<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results List</title>
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
	
	<c:set var="count" value="0" />
	<c:forEach items="${results}">
		<c:set var="count" value="${count + 1}" />
	</c:forEach>
	
	<div class="main">
		<h4>Results List
			<c:if test="${not empty success}">
				&nbsp;-&nbsp;&nbsp;<span class="successMessage">${success}</span>
			</c:if>
			<c:if test="${count == 0}">
				&nbsp;-&nbsp;&nbsp;<span class="errorMessage">The Result List is Empty !!</span>
			</c:if>
		</h4>
		<hr/>
		<br/>
		<table border="1" align="left">
			<tr>
				<th style="padding:10px">Course Name</th>
				<th style="padding:10px">Student Name</th>
				<th style="padding:10px">Email</th>
				<th style="padding:10px">Score</th>
			</tr>
			<c:forEach items="${results}" var="result">
				<tr>
					<td style="padding:10px">${result.courseName}</td>
					<td style="padding:10px">${result.studentName}</td>
					<td style="padding:10px">${result.email}</td>
					<td style="padding:10px;text-align:center;">${result.score}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>













