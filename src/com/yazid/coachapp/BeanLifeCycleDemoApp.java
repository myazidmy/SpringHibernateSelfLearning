package com.yazid.coachapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		//load sprint container file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		//retrieve bean from spring container
		Coach headCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(headCoach.getDailyWorkout());
		
		context.close();
	}
	

}
