package com.evoke.constructorspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLaptops {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springbean.xml");
		Laptops laptop = (Laptops) applicationContext.getBean("laptops");
        System.out.println(laptop.toString());
        
        Laptops laptop1 = (Laptops) applicationContext.getBean("laptops1");
        System.out.println(laptop1.toString());
        
        
        

	}

}
