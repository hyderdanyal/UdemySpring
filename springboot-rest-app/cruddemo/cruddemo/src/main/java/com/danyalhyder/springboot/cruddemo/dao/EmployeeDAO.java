package com.danyalhyder.springboot.cruddemo.dao;

import java.util.List;

import com.danyalhyder.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	
}
