package com.danyalhyder.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danyalhyder.springdemo.entity.Customer;
import com.danyalhyder.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//Autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	//Add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	//Add mapping for GET /customers/{customerId}
		@GetMapping("/customers/{customerId}")
		public Customer getCustomer(@PathVariable int customerId){
			
			Customer theCustomer = customerService.getCustomer(customerId);
			
			if(theCustomer == null) {
				throw new CustomerNotFoundException("Customer id not found - "+customerId);
			}
			
			return theCustomer;
		}
	
	//add mapping for POST/customers - add new customerss
		
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//Since saveOrUpdate method pass id as 0 to create new entry
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
		
	//Add mapping for PUT/customers - updating existing customers
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer; 
	}
		
		
		
}
