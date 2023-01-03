package com.petstore.utils;

import java.util.Random;

public class TestUtils {

	public static String getRandomValue(){
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		return Integer.toString(randomInt);
	}

	public static int getRandomNum(){
		Random random = new Random();
		int randomInt = random.nextInt(10000);
		return randomInt;
	}
	public static String getRandomPhone(){
		Random random = new Random();
		int randomLong = random.nextInt(1000000000);
		return Integer.toString(randomLong);
	}
}
