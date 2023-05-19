package com.studentresultmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.studentresultmanagement.DAO.AppDAOImpl;
import com.studentresultmanagement.config.AppConfig;
import com.studentresultmanagement.model.Course;
import com.studentresultmanagement.model.Result;
import com.studentresultmanagement.model.Student;

@Controller
public class AppController {

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping("/listStudents")
	public ModelAndView listStudents(@RequestParam Optional<String> deleteStudent) {
		ModelAndView model = new ModelAndView("listStudents");
		List<Student> students = new ArrayList<Student>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		if(deleteStudent.isPresent()) {
			if(DAO.deleteStudent(deleteStudent.get())) {
				model.addObject("success", "Student Deleted Successfully !!");
			}
		}
		students = DAO.listStudents();
		model.addObject("students", students);
		context.close();
		return model;
	}

	@RequestMapping("/addStudent")
	public String addStudent(Model model, @Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("student", student);
		} else {
			if (student.getFirstName() != null && student.getFamilyName() != null && student.getDob() != null
					&& student.getEmail() != null) {
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate dateOfBirth = LocalDate.parse(student.getDob(), formatter);
				LocalDate currentDate = LocalDate.now();
		        LocalDate minimumDateOfBirth = currentDate.minusYears(10);

		        if(dateOfBirth.isBefore(minimumDateOfBirth) || dateOfBirth.isEqual(minimumDateOfBirth)) {
					AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
					AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
					if(DAO.addStudent(student)) {
						student.setFirstName("");
						student.setFamilyName("");
						student.setDob("");
						student.setEmail("");
						model.addAttribute("success", "Student Added Successfully !!");
					} else {
						model.addAttribute("error", "Error: Duplicate Student Entry, Student Already Added !!");
					}
					context.close();
		        } else {
		        	model.addAttribute("error", "Error: Student must be at least 10 years old to get Added !!");
		        }
			} 
		}
		return "addStudent";
	}
	
	@RequestMapping("/listCourses")
	public ModelAndView listCourses(@RequestParam Optional<String> deleteCourse) {
		ModelAndView model = new ModelAndView("listCourses");
		List<Course> courses = new ArrayList<Course>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		if(deleteCourse.isPresent()) {
			if(DAO.deleteCourse(deleteCourse.get())) {
				model.addObject("success", "Course Deleted Successfully !!");
			}
		}
		courses = DAO.listCourses();
		model.addObject("courses", courses);
		context.close();
		return model;
	}

	@RequestMapping("/addCourse")
	public String addCourse(Model model, @Valid Course course, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("course", course);
		} else {
			if (course.getCourseName() != null) {
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
				if(DAO.addCourse(course)) {
					course.setCourseName("");
					model.addAttribute("success", "Course Added Successfully !!");
				} else {
					model.addAttribute("error", "Error: Duplicate Course Entry, Course Already Added !!");
				}
				context.close();
			} 
		}
		return "addCourse";
	}
	
	@RequestMapping("/listResults")
	public ModelAndView listResults() {
		ModelAndView model = new ModelAndView("listResults");
		List<Result> results = new ArrayList<Result>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		results = DAO.listResults();
		model.addObject("results", results);
		context.close();
		return model;
	}

	@RequestMapping("/addResult")
	public String addResult(Model model, @Valid Result result, BindingResult br) {
		List<Course> courses = new ArrayList<Course>();
		List<Student> students = new ArrayList<Student>();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);
		courses = DAO.listCourses();
		students = DAO.listStudents();
		model.addAttribute("courses", courses);
		model.addAttribute("students", students);
		if (br.hasErrors()) {
			model.addAttribute("result", result);
		} else {
			if (result.getCourseName() != null && result.getStudentName() != null && result.getEmail() != null
					&& result.getScore() != null) {
				if(DAO.addResult(result)) {
					result.setCourseName("");
					result.setStudentName("");
					result.setEmail("");
					result.setScore("");
					model.addAttribute("success", "Result Added Successfully !!");
				} else {
					model.addAttribute("error", "Error: Duplicate Result Entry, Result Already Added !!");
				}
			} 
		}
		context.close();
		return "addResult";
	}
}
