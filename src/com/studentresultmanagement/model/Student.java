package com.studentresultmanagement.model;

import org.hibernate.validator.constraints.Email;

public class Student {
	
	private String firstName;
	private String familyName;
	private String dob;
	@Email(message = "Not a Well-Formed Email Address !!")
	private String email;
	
	public Student(String firstName, String familyName, String dob, String email) {
		this.firstName = firstName;
		this.familyName = familyName;
		this.dob = dob;
		this.email = email;
	}
	
	public Student() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}