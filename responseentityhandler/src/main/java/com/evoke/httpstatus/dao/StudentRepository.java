package com.evoke.httpstatus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evoke.httpstatus.model.Students;
@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
	
	public Students findByRollNo(int rollNo);
	//public Students deleteByRollNo(int rollNo);

}
