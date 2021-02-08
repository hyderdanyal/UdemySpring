package com.springAnnotationsDemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Value("${foo.Fortunes}")
	private String[] Fortunes;
	
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(Fortunes.length);
		return Fortunes[index];
	}

}
