package com.yazid.coachapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load sprint container file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		//retrieve bean from spring container
		Coach headCoach = context.getBean("myCoach", Coach.class);
		Coach mainCoach = context.getBean("myCoach", Coach.class);
		
		//the two objects of main and head coach are pointing to the same object
		boolean result = (headCoach == mainCoach);
		System.out.println("\n Pointing to the same object: " + result);
		System.out.println("\n Memory address of mainCoach: " + mainCoach);
		System.out.println("\n Memory address of headCoach: " + headCoach);

	}
	

}
