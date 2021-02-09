package com.springAnnotationsDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Get bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//Call our new getter methods
		System.out.println("Email:  " +theCoach.getEmail());
		System.out.println("Team:  " +theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
