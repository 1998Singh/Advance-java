package com.evoke.springboottesting.service;

import java.util.List;

import com.evoke.springboottesting.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee updateEmployee(Employee updateEmployee);

}
