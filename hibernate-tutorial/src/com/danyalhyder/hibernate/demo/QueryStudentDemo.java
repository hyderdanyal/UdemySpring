package com.danyalhyder.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danyalhyder.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			//Start a transaction
			session.beginTransaction();
			
			//Query Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//Display students
			displayStudents(theStudents);
			
			//Query Student where lastname=Duck
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			//Display students
			System.out.println("Students who have lastname as duck: ");
			displayStudents(theStudents);
			
			//Query Student where lastname=Duck or firstname=Daffy
			theStudents = session.createQuery("from Student s where " + "s.lastName='Duck' OR s.firstName='Daffy'").getResultList();

			//Display students
			System.out.println("Students who have lastname as duck or firstname as daffy: ");
			displayStudents(theStudents);
			
			//Query student where email ends with duck.com
			theStudents = session.createQuery("from Student s where " + "s.email LIKE  '%duck.com'").getResultList();
			
			//Display students
			System.out.println("Students who have email ending with duck.com: ");
			displayStudents(theStudents);
				
			
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
