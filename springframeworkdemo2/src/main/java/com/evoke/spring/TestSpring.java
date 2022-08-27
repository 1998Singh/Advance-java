package com.evoke.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evoke.service.Cars;
import com.evoke.service.Jaguar;
import com.evoke.service.LandRover;


public class TestSpring {

	public static void main(String[] args) {
		
		ApplicationContext application= new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Cars jaguar =application.getBean(Jaguar.class);
		jaguar.companyName();
		jaguar.price();
		
		Cars rover =application.getBean(LandRover.class);
		rover.companyName();
		rover.price();
		

	}

}
