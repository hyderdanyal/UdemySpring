package com.springAnnotationsDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import javax.annotation.PostConstruct;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	private String[] array;
	
	@PostConstruct
	public void doMyStartupStuff() {
	System.out.println(" \n DatabaseFortuneService: Inside doMyStartupStuff() ");	
	Path fileName = Path.of("C:\\Users\\MY PC\\eclipse-workspace-udemy\\UdemySpring\\spring-demo-annotations\\src\\Fortunes.txt");
	String actual = null;
	try {
		actual = Files.readString(fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	array = actual.split(","); 

    System.out.println("Array created:" +array);
	}
	
//	@Value("${foo.Fortunes}")
//	private String[] Fortunes;
	
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(array.length);
		return array[index];
	}

}
