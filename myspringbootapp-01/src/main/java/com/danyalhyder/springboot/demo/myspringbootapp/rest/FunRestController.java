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

}
