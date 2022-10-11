package com.evoke.unittest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.evoke.unittest.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId =:id")
	Boolean isPersonExitsById(Integer id);
	

}
