package com.danyalhyder.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danyalhyder.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	public StudentRestController() {
		// TODO Auto-generated constructor stub
	}

	//Define endpoint for /students return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Valentino","Rossi"));
		theStudents.add(new Student("Mary","Lee"));
		
		
		return theStudents;
	}
	
}
