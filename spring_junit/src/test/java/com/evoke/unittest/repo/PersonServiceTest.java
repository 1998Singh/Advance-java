package com.evoke.unittest.repo;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.evoke.unittest.service.PersonService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PersonServiceTest {
	
	@Mock
	private PersonRepo personRepo;
	
	private PersonService personService;
	
	@BeforeEach
	void setUp() {
		this.personService = new PersonService(this.personRepo);
	}
	
	@Test
	void getAllPerson() {
		personService.getAllPerson();
		verify(personRepo).findAll();
	}
	
	

}
