package com.springAnnotationsDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach {
	
	//Field Injection
	@Autowired
	@Qualifier("databaseFortuneService")
	private FortuneService fortuneService;
	
	/* Constructor Injection
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	
	//Define a default constructor
	public TennisCoach() {
		System.out.println("\n TennisCoach: Inside default constructor");
	}
	
	/*
	//Any method can be turned to Dependency
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("\n TennisCoach: Inside doSomeCrazyStuff() method: ");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	//Define a setter method
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("\n TennisCoach: Inside setFortuneService() method: ");
		fortuneService = theFortuneService;
	}
	*/
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
