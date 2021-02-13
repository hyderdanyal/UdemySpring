package com.danyalhyder.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danyalhyder.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		//Use the session object to save the java object using jdbc
			
			//Create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Daffy", "Duck", "Daffy@Duck.com");
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			
			
		//Retrieve data from the database
			
			//Find the students primary key: id
			System.out.println("Saved student generated id: " +tempStudent.getId());
			
			//Get a new session and start transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
						
			//Retrieve the student based on primary key
			System.out.println("\n Getting student with id: " +tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: \n Student: " +myStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
