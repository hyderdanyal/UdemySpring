package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//Load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve beans from container
		SoccerCoach theCoach = context.getBean("mySoccerCoach",SoccerCoach.class);
//		//Call methods on beans
		System.out.println(theCoach.getDailyWorkout());
//		// Call newly injected fortune method
		System.out.println(theCoach.getDailyFortune());
		//Call our methods to get injected literals value
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		//Close the app context
		context.close();

	}

}
