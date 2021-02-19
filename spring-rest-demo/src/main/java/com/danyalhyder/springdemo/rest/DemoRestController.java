package com.danyalhyder.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	public DemoRestController() {
		// TODO Auto-generated constructor stub
	}
	
	//Add code for the /hello endpoint
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World !";
	}
	

}
