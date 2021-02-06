package com.springDemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService; 
	
	public TrackCoach() {}
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 5 km";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do It" + fortuneService.getFortune();
	}

	

}
