package com.studentresultmanagement.DAO;

import java.util.List;

import com.studentresultmanagement.model.Student;

import com.studentresultmanagement.model.Course;

import com.studentresultmanagement.model.Result;

public interface AppDAO {

	public List<Student> listStudents();

	public boolean addStudent(Student student);
	
	public List<Course> listCourses();

	public boolean addCourse(Course course);
	
	public List<Result> listResults();

	public boolean addResult(Result result);
}
