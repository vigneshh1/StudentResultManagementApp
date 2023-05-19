package com.studentresultmanagement.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.studentresultmanagement.model.Course;
import com.studentresultmanagement.model.Result;
import com.studentresultmanagement.model.Student;

public class AppDAOImpl implements AppDAO {

	private DataSource dataSource;

	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> listStudents() {
		String SQL = "Select * from students";
		List<Student> listStudents = new ArrayList<Student>();
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs =  ps.executeQuery();
	        while(rs.next()){
	        	Student temp = new Student(
	        			rs.getString("first_name"),
	        			rs.getString("family_name"),
	        			rs.getString("dob"),
	        			rs.getString("email")
	        			);
	        	listStudents.add(temp);
	        }
		    rs.close();
		    ps.close();
		    return listStudents;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {e.printStackTrace();}
			}	
		}
	}

	public boolean addStudent(Student student) {
		String SQL = "Insert into students(first_name, family_name, dob, email) values (?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getFamilyName());
			ps.setString(3, student.getDob());
			ps.setString(4, student.getEmail());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean deleteStudent(String studentEmail) {
		String deleteStudentSQL = "Delete from students where email = ?";
		String deleteResultsSQL = "Delete from results where email = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(deleteResultsSQL);
			ps.setString(1, studentEmail);
			ps.execute();
			ps.close();
			ps = conn.prepareStatement(deleteStudentSQL);
			ps.setString(1, studentEmail);
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Course> listCourses() {
		String SQL = "Select * from courses";
		List<Course> listCourses = new ArrayList<Course>();
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs =  ps.executeQuery();
	        while(rs.next()){
	        	Course temp = new Course(
	        			rs.getString("course_name")
	        			);
	        	listCourses.add(temp);
	        }
		    rs.close();
		    ps.close();
		    return listCourses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {e.printStackTrace();}
			}
		}
	}

	public boolean addCourse(Course course) {
		String SQL = "Insert into courses(course_name) values (?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, course.getCourseName());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean deleteCourse(String course) {
		String deleteCoursesSQL = "Delete from courses where course_name = ?";
		String deleteResultsSQL = "Delete from results where course_name = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(deleteResultsSQL);
			ps.setString(1, course);
			ps.execute();
			ps.close();
			ps = conn.prepareStatement(deleteCoursesSQL);
			ps.setString(1, course);
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Result> listResults() {
		String SQL = "Select * from results";
		List<Result> listResults = new ArrayList<Result>();
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs =  ps.executeQuery();
	        while(rs.next()){
	        	Result temp = new Result(
	        			rs.getString("course_name"),
	        			rs.getString("student_name"),
	        			rs.getString("email"),
	        			rs.getString("score")
	        			);
	        	listResults.add(temp);
	        }
		    rs.close();
		    ps.close();
		    return listResults;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {e.printStackTrace();}
			}
		}
	}

	public boolean addResult(Result result) {
		String SQL = "Insert into results " + "(course_name, student_name, email, score) values (?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, result.getCourseName());
			ps.setString(2, result.getStudentName());
			ps.setString(3, result.getEmail());
			ps.setString(4, result.getScore());
			ps.execute();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}





























