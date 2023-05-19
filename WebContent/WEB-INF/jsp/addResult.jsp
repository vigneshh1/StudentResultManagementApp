<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Results</title>
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
		<h4>Add New Results
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
		<form:form modelAttribute="result" action="addResult">
		<tr><td>Course Name</td><td> <form:select required="true" path="courseName" style="margin:10px">
			<form:option value="" label="Please Select"/>
	  		<form:options items="${courses}" itemValue="courseName" itemLabel="courseName"/>
		</form:select>
		<form:errors path="courseName" cssStyle="color:red"></form:errors></td></tr>
		<tr><td>Student Name</td><td> <select id="selectStudent" required="true" style="margin:10px" onchange="javascript:updateStudentEmail()">
			<option value="" label="Please Select"/>
			<c:forEach items="${students}" var="student">
	  			<option value="${student.firstName} ${student.familyName}=::=${student.email}" label="${student.firstName} ${student.familyName}"/>
	  		</c:forEach>
		</select>
		<form:errors path="studentName" cssStyle="color:red"></form:errors></td></tr>
		<form:hidden id="studentName" path="studentName"/>
		<form:hidden id="email" path="email"/>
		<tr><td>Email</td><td><h5 id="emailValue" style="margin:10px">Please Select a Student to populate Email</h5></td></tr>
		<tr><td>Score</td><td> <form:select path="score" required="true" style="margin:10px">
			<form:option value="" label="Please Select"/>
	  		<form:option value="A" label="A"/>
	  		<form:option value="B" label="B"/>
	  		<form:option value="C" label="C"/>
	  		<form:option value="D" label="D"/>
	  		<form:option value="E" label="E"/>
	  		<form:option value="F" label="F"/>
		</form:select>
		<form:errors path="score" cssStyle="color:red"></form:errors></td></tr>
		<tr><td><input type="submit" style="margin-top:15px" value="Submit"></td></tr>
		</form:form>
		</table>
	</div>
	
	<script type="text/javascript">
		function updateStudentEmail() {
			var studentSelected = (document.getElementById("selectStudent").value);
			if(studentSelected === ""){
				document.getElementById("emailValue").innerHTML = "Please Select a Student to populate Email";
				document.getElementById("email").value = null;
				document.getElementById("studentName").value = null;
			} else{
				studentSelected = studentSelected.split("=::=");
				document.getElementById("emailValue").innerHTML = studentSelected[1];
				document.getElementById("email").value = studentSelected[1];
				document.getElementById("studentName").value = studentSelected[0];
			}
		}
	</script>
	
</body>
</html>