package com.evoke.factorypattern;


import com.evoke.factorypattern.phone.OperatingSystem;
import com.evoke.factorypattern.phone.OperatingSystemFactory;

public class FactoryMain {

	public static void main(String[] args) {
		
		OperatingSystemFactory operFactory =new OperatingSystemFactory();
		OperatingSystem operatingSystem= operFactory.getInstance("Close");
	    operatingSystem.spec();

	}

}
