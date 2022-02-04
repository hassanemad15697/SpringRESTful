package com.spring.SpringRESTful.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringRESTful.Exception.StudentException;
import com.spring.SpringRESTful.Model.Student;
import com.spring.SpringRESTful.Model.StudentExceptionHandler;

@RestController
public class MainController {

	// http://localhost:8080/SpringRESTful/home
	@GetMapping("/home")
	public String home() {
		return "Hi Askar";
	}

	// http://localhost:8080/SpringRESTful/students
	@GetMapping("/students")
	public List<Student> students() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Hassan", "Egypt/Cairo", 24));
		students.add(new Student(2, "Amro", "Egypt/Sharkia", 22));
		students.add(new Student(3, "Esraa", "Italy/Roma", 21));
		students.add(new Student(4, "Hager", "Italy/Milano", 19));
		return students;
	}

	// http://localhost:8080/SpringRESTful/get-student/{studentId}
	@GetMapping("/get-student/{studentId}")
	public Student fwrStudentById(@PathVariable("studentId") int id) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Hassan", "Egypt/Cairo", 24));
		students.add(new Student(2, "Amro", "Egypt/Sharkia", 22));
		students.add(new Student(3, "Esraa", "Italy/Roma", 21));
		students.add(new Student(4, "Hager", "Italy/Milano", 19));

		if (id < 0 || id > students.size()) {
			 throw new StudentException("student not founded becuase id " + id);
		}
		return students.get(id - 1);
	}

	// http://localhost:8080/SpringRESTful/get-student-id?id=
	@GetMapping("/get-student-id")
	public Student getStudentById(@RequestParam int id) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Hassan", "Egypt/Cairo", 24));
		students.add(new Student(2, "Amro", "Egypt/Sharkia", 22));
		students.add(new Student(3, "Esraa", "Italy/Roma", 21));
		students.add(new Student(4, "Hager", "Italy/Milano", 19));
		if (id < 0 || id > students.size()) {
			 throw new StudentException("student not founded becuase id " + id);
		}
		return students.get(id - 1);
	}



}
