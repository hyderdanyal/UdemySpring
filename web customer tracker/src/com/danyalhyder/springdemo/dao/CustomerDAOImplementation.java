package com.danyalhyder.springdemo.dao;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
		//Create a query... also sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);
		//Execute query and get results
		List<Customer> customers = theQuery.getResultList();
		//Return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer or update the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//retrieve from db using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
	}

}
