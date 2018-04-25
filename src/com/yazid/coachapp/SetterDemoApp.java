package com.yazid.coachapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load the spring config files
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve the bean from the spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
		//call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				
		//lets call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		//calling our new methods to get the literal vales for team and email
		//Spring will capatilize the first letter of the property name and get that shit
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());

		//close the context
		context.close();
	}
	

}
