package com.springAnnotationsDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Get bean from spring container
//		Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
