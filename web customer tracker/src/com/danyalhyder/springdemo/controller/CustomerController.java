package com.danyalhyder.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danyalhyder.springdemo.dao.CustomerDAO;
import com.danyalhyder.springdemo.entity.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	//Need to inject CustomerController
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//Get the customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		
		//Add them to spring mvc
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers"; 
	}
	
}