package com.danyalhyder.springdemo.dao;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danyalhyder.springdemo.dao.CustomerDAO;
import com.danyalhyder.springdemo.entity.Customer;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

	public CustomerDAOImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Customer> getCustomers() {
		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		//Execute query and get results
		List<Customer> customers = theQuery.getResultList();
		//Return the results		
		return customers;
	}

}
