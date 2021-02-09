package com.springAnnotationsDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("singleton")
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
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("\n TennisCoach: Inside doMyStartupStuff() ");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("\n TennisCoach: Inside doMyCleanupStuff() ");
	}
	
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
