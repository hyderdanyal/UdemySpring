package com.springDemo;

public class SoccerCoach implements Coach {
	
	private FortuneService fortuneService;	
	//add new fields
	private String emailAddress;
	private String team;
	
	//Create a no-argconstructor for setter injection
	public SoccerCoach() {
		System.out.println("soccercoach: inside no-arg constructor");
	}
	
	//Our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("soccercoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAddress() {
		System.out.println("soccercoach: inside getter method - getEmailAddress");
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("soccercoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		System.out.println("soccercoach: inside getter method - getTeam");
		return team;
	}

	public void setTeam(String team) {
		System.out.println("soccercoach: inside setter method - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Dribble the ball";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
