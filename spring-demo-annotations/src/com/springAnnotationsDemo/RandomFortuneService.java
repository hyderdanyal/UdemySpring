package com.springAnnotationsDemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//Create an array of Strings
	private String[] data = {
			"Beware of the wolf",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	//Create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//Pick a random String from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
