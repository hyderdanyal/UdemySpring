package com.danyalhyder.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danyalhyder.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImplementation implements EmployeeDAO {

	//Define field for entitymanager
	
	private EntityManager entityManager;
	
	//set up constructor injection	
	@Autowired
	public EmployeeDAOHibernateImplementation(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//Get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		//Return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//Save the employee
		currentSession.saveOrUpdate(theEmployee);
				
		
	}

	@Override
	public void deleteById(int theId) {
		//Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//Delete the employee by Id
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
				
		
	}

}
