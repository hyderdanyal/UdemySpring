package com.springAnnotationsDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve beans from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		//Check if they are the same
		boolean result = (theCoach == alphaCoach);
		System.out.println("Both the beans point to the same object:" +result);
		System.out.println("Memory location for theCoach:" +theCoach);
		System.out.println("Memory location for alphaCoach:" +alphaCoach);
		//Close context
		context.close();
	}

}
