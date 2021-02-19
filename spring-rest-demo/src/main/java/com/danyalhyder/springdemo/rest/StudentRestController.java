package com.danyalhyder.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		//Check the studentId against list Size
		if (studentId >=theStudents.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student not found - " +studentId);
		}
		
		return theStudents.get(studentId);
	}
	
//	//Add an exception handler using @ExceptionHandler for studentnotfound
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//		
//		//Create a StudentErrorResponse
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		//Return ResponseEntity
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	
//	//Add anotheer exception handler for all types of exception
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//		
//		//Create a StudentErrorResponse
//		
//				StudentErrorResponse error = new StudentErrorResponse();
//				error.setStatus(HttpStatus.BAD_REQUEST.value());
//				error.setMessage(exc.getMessage());
//				error.setTimeStamp(System.currentTimeMillis());
//				
//				//Return ResponseEntity
//				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	
//	}
	
}
