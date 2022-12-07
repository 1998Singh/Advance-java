package com.evoke.singletone;

//SingleTone Design Pattern

public class SingleToneExample {

	public static SingleToneExample obj;

	int i;

	private SingleToneExample() { // Constructor

		System.out.println("Instance Created");

	}

	public static SingleToneExample getInstance() {

		if (obj == null) {

			obj = new SingleToneExample();
		}

		return obj;
	}

}
