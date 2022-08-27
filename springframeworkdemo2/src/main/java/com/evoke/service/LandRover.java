package com.evoke.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LandRover implements Cars {
	
	private static  Logger logger =	LogManager.getLogger(LandRover.class);
	
	public String companyName() {
		
		logger.debug("Land Rover Discover ");
		
			return "Land Rover";
	}

	public void price() {
		
		logger.debug("Price is 1.5cr ");
	}

}
