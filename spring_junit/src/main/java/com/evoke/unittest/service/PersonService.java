package com.evoke.unittest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.unittest.entity.Person;
import com.evoke.unittest.repo.PersonRepo;

@Service
public class PersonService {

	private static final Logger log = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private PersonRepo repo;

	public List<Person> getAllPerson() {
		
		try {
			log.info("This is Info");
			return this.repo.findAll();
		} 
		catch (Exception e) {
			
			log.error(e.toString());
		}
		return null;

	}

	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}

}
