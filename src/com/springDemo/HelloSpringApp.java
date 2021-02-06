package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve beans from container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		//Call methods on beans
		System.out.println(theCoach.getDailyWorkout());
		// Call newly injected fortune method
		System.out.println(theCoach.getDailyFortune());
		//Close the app context
		context.close();
	}

}
