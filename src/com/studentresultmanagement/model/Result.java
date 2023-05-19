package com.studentresultmanagement.model;

public class Result {
	
	private String courseName;
	private String studentName;
	private String email;
	private String score;
	
	public Result(String courseName, String studentName, String email, String score) {
		this.courseName = courseName;
		this.studentName = studentName;
		this.email = email;
		this.score = score;
	}
	
	public Result() {
		
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
}