package com.evoke.springgetterandsetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		University university = (University) applicationContext.getBean("universityBean");
	     System.out.println(university.toString());
	}
}
