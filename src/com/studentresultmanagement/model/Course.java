package com.studentresultmanagement.model;

public class Course {
	
	private String courseName;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public Course() {
		
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}