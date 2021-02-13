package com.danyalhyder.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danyalhyder.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 12;
			
			//Get a new session and start transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
						
			//Retrieve the student based on primary key
			System.out.println("\n Getting student with id: " +studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			//Delete the student
			System.out.println("Deleting syudent with id: " +myStudent);
			session.delete(myStudent);
			
			//Delete the student with studentid=2
			System.out.println("Deleting student with id=2 :");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
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
