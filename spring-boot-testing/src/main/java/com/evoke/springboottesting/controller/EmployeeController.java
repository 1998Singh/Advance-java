package com.evoke.springboottesting.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.springboottesting.model.Employee;
import com.evoke.springboottesting.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

 Logger log = LogManager.getLogger(EmployeeController.class);

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getAllEmployee()
	 {
		log.debug("This is debige massage");
		return employeeService.getAllEmployee();
		}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee)
	{
         log.info("This is info massage");
		return employeeService.saveEmployee(employee);
	}
}
