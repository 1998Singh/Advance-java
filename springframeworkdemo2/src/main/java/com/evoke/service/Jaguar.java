package com.evoke.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Jaguar implements Cars{
	
	private static  Logger logger =	LogManager.getLogger(Jaguar.class);

	public String companyName() {
		
		logger.debug(" Jaguar F Phace . ");
		return "Jaguar Cars";
	}

	public void price() {
		
		logger.debug(" Price is 8000000L .");
		
	}

}
