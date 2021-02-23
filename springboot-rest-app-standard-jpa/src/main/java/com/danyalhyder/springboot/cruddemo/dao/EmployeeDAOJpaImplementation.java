package com.danyalhyder.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danyalhyder.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImplementation(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//Create a query 
		Query theQuery = entityManager.createQuery("from Employee");
		//Execute query and return list
		List<Employee> employees = theQuery.getResultList();
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//Get employee
		Employee theEmployee =  entityManager.find(Employee.class, theId);
		//Return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// Save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//Update with id from db ... for generated id
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		// Delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
