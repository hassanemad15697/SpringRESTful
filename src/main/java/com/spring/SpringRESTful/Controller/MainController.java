package com.spring.SpringRESTful.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringRESTful.Model.Student;

@RestController
public class MainController {

	//http://localhost:8080/SpringRESTful/home
	@GetMapping("/home")
	public String home()
	{
		return "index";
	}
	
	// http://localhost:8080/SpringRESTful/students
	@GetMapping("/students")
	public List<Student> students()
	{
		
		List<Student> students = new ArrayList<Student>() ; 
		students.add(new Student(1, "Hassan", "Egypt/Cairo", 24));
		students.add(new Student(2, "Amro", "Egypt/Sharkia", 22));
		students.add(new Student(3, "Esraa", "Italy/Roma", 21));
		students.add(new Student(4, "Hager", "Italy/Milano",19));
		return students;
	}
	// http://localhost:8080/SpringRESTful/get-student/{studentId}
	@GetMapping("/get-student/{studentId}")
	public Student fwrStudentById( @PathVariable("studentId") int id)
	{
		
		List<Student> students = new ArrayList<Student>() ; 
		students.add(new Student(1, "Hassan", "Egypt/Cairo", 24));
		students.add(new Student(2, "Amro", "Egypt/Sharkia", 22));
		students.add(new Student(3, "Esraa", "Italy/Roma", 21));
		students.add(new Student(4, "Hager", "Italy/Milano",19));
		
		
		return students.get(id-1);
	}
}
