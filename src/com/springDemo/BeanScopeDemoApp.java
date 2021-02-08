package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");  
		//Retrieve the beans
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		//Check if they are the same beans
		boolean result = (theCoach == alphaCoach);
		//Print out the result
		System.out.println("\n Pointing to the same object:" +result);
		System.out.println("\n Memory location for theCoach:" +theCoach);
		System.out.println("\n Memory location for alphaCoach:" +alphaCoach + "\n");
		//close the context
		context.close();
		
	}

}
