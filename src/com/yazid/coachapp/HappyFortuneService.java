package com.yazid.coachapp;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	
	final String[] fortuneArray = {"You will die", "It couldnt get worse", "You win", "Google back to school necklace"};
	Random random = new Random();


	@Override
	public String getFortune() {
	
		//sets a number to i to choose from the array
		int i = random.nextInt(fortuneArray.length);
		return fortuneArray[i];
		
	}

}
