package com.evoke.employeeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.employeeapplication.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
