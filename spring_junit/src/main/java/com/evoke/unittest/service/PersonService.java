package com.evoke.unittest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.unittest.entity.Person;
import com.evoke.unittest.repo.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo repo;
	
	

	public List<Person> getAllPerson(){
		return this.repo.findAll();
	}
	
	
	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}
	
	

}
