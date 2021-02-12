package com.danyalhyder.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	//Need a controller method for showing initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Need a controller method for processing form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//New controller method to read form data
	//Add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		//read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		//convert data to all caps
		theName = theName.toUpperCase();
		//create the message
		String result= "Yo! " +theName;
		//add message to model
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		//convert data to all caps
		theName = theName.toUpperCase();
		//create the message
		String result= "Hey my Friend! " +theName;
		//add message to model
		model.addAttribute("message",result);
		return "helloworld";
	}
	
}
