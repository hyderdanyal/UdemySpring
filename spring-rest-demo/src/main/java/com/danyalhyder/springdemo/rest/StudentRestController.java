package com.danyalhyder.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danyalhyder.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load student data... only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Valentino","Rossi"));
		theStudents.add(new Student("Mary","Lee"));
	}

	public StudentRestController() {
		// TODO Auto-generated constructor stub
	}

	//Define endpoint for /students return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	//Define endpoint for /students/{studentId} and return particular student
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//Index the list to the arguement id
		return theStudents.get(studentId);
	}
	
}
