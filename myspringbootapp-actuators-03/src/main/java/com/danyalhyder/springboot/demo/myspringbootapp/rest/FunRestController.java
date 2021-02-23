package com.danyalhyder.springboot.demo.myspringbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//Expose "/" that returns hello world
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello World! Time on server is " +LocalDateTime.now();
	}
	
	//Expose a new endpoint for "workout" to check if automatically reloads
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a hard 5km";
	}
	
	//Another check
	@GetMapping("/fortune")
	public String getDailyFortune() {
		
		return "Today is your lucky day!!";
	}

}
