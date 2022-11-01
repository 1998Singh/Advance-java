package com.evoke.springboottesting.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import com.evoke.springboottesting.exception.ResourceNotFoundException;
import com.evoke.springboottesting.model.Employee;
import com.evoke.springboottesting.repository.EmployeeRepository;
import com.evoke.springboottesting.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger log = LogManager.getLogger(EmployeeServiceImpl.class);

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		log.info("This is Info Massage");

		Optional<Employee> saveEmployee = employeeRepository.findByEmail(employee.getEmail());
		if (saveEmployee.isPresent()) {
			throw new ResourceNotFoundException("Employee already exit with given mail" + employee.getEmail());
		}

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			log.debug("This is Debug Massage");
			return employeeRepository.findAll();
		} catch (Exception e) {
			log.error(e.toString());
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee updateEmployee) {
		try {
			log.error("This is for error info");
			return employeeRepository.save(updateEmployee);
		} catch (Exception e) {
			log.error(e.toString());
		}
		return null;
	}

}
