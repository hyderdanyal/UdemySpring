package com.danyalhyder.springboot.cruddemo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.danyalhyder.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//No need to write any code automatic crud support
}
