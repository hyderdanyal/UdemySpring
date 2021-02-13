package com.danyalhyder.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danyalhyder.hibernate.demo.entity.Student;

public class EmployeeDemo {

	public static void main(String[] args) {
		int employeeId=5;
		
		SessionFactory factory = new Configuration()
								.configure("employeehibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//Create
			System.out.println("Creating a new employee object...");
			Employee tempEmployee = new Employee("Paul", "Wall", "Google");
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the employee...");
			session.save(tempEmployee);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
			//Read
			session =factory.getCurrentSession();
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, tempEmployee.getId());
			System.out.println("Get Complete: \n Student: " +myEmployee);
			
			session.getTransaction().commit();
			System.out.println("Done !");
			
			//Query for company google
			
			session =factory.getCurrentSession();
			session.beginTransaction();
			List<Employee> theEmployees = session.createQuery("from Employee e where e.company='Google'").getResultList();
			System.out.println("Company name google:");
			for(Employee e:theEmployees) {
				System.out.println(e);
			}
			
			// Delete
			
			Employee emp = session.get(Employee.class, employeeId);
			System.out.println("Deleting syudent with id: " +employeeId);
			session.delete(emp);
			
			session.getTransaction().commit();
			System.out.println("Done !");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
