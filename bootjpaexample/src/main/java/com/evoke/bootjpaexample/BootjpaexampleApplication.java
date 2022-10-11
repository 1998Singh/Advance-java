package com.evoke.bootjpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.evoke.bootjpaexample.dao.UserRepository;
import com.evoke.bootjpaexample.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) 
	{
		ApplicationContext  context=  SpringApplication.run(BootjpaexampleApplication.class, args);
		
	UserRepository repository =	context.getBean(UserRepository.class);
	
	User user = new User();
	//user.setId(1);
	user.setName("Sharad Singh");
	user.setCity("Pratapgarh");
	
	User user1 =repository.save(user);
	System.out.println(user1);
		

		

	}

}
