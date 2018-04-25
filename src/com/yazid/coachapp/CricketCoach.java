package com.yazid.coachapp;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
		
	//create a no arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: constructor is activated");
	}
	
	//injecting email adderss
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: setter has been called - email adderss");
		this.emailAddress = emailAddress;
	}

	//injecting team name
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: setter has been called - team");
		this.team = team;
	}



	//the setter method that ill be called by spring when they call the dependency
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("CricketCoach: setter has been called");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "spend speed bowl for ten hours";
	}

	@Override
	public String getDailyFortune() {
		
		//use my fortuneService to get a fortune
		
		return fortuneService.getFortune();
			}
}
