package com.danyalhyder.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danyalhyder.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//Get a new session and start transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
						
			//Retrieve the student based on primary key
			System.out.println("\n Getting student with id: " +studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating Student: " +myStudent);
			myStudent.setFirstName("Scooby");
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
			//Update query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@bar.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
