package com.evoke.unittest.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.evoke.unittest.entity.Person;

@SpringBootTest
public class PersonRepoTest {

	@Autowired
	private PersonRepo personrepo;

	@Test
	void isPersonExitsById() {
        
		Person person = new Person(123, "Rahul", "Himachal");
		personrepo.save(person);
		Boolean actualResult = personrepo.isPersonExitsById(123);
		assertThat(actualResult).isTrue();
	}
	
	
	

}
