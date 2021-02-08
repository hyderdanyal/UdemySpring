package com.springDemo;

public class MyApp {

	public static void main(String[] args) {
		// Create the object
		Coach trackCoach = new TrackCoach();
//		Coach baseballCoach = new BaseballCoach();
		//Use the object
		System.out.println(trackCoach.getDailyWorkout());
//		System.out.println(baseballCoach.getDailyWorkout());
	}

}
