package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeHelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", Coach.class);
		Coach alphaCoach = context.getBean("myGolfCoach", Coach.class);
		
		// Check if they are the same bean
		boolean result = (theCoach == alphaCoach);
		System.out.println("\n Same bean:" +result);
		System.out.println("\n Memory location for theCoach:" +theCoach);
		System.out.println("\n Memory location for alphaCoach:" +alphaCoach + "\n");
				
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
