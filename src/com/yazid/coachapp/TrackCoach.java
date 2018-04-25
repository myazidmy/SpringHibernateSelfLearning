package com.yazid.coachapp;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "kill yourself running";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: " + fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: Inside Start up Method");
	}
	
	//add destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: Inside Clean up Method");
	}
}
