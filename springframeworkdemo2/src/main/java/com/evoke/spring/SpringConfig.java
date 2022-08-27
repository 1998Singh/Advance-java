package com.evoke.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evoke.service.Cars;
import com.evoke.service.Jaguar;
import com.evoke.service.LandRover;

@Configuration // class can used by spring ioc as source of bean definition.
public class SpringConfig {

	@Bean // return object.
	public Cars getJaguar() {

		return new Jaguar();
	}

	@Bean
	public Cars getLandRover() {

		return new LandRover();

	}

}
