package com.evoke.employeeapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.employeeapplication.exception.ResourceNotFoundException;
import com.evoke.employeeapplication.model.Employee;
import com.evoke.employeeapplication.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// get all employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
       // get employee By id 
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getById(@PathVariable(name = "id") long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isPresent()) {
			 Employee employee =  employeeOptional.get();
			 return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}else {
			throw new RuntimeException("No employee found for Id "+id);
		}
	}

	// create employee
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		 employee =  employeeRepository.save(employee);
		 return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
      // update Employee
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> update(@PathVariable(name = "id") Long id, @RequestBody Employee employeeDetails) {
     Employee employee = employeeRepository.findById(id)
    		 .orElseThrow(()-> new ResourceNotFoundException("Employee not exit with id :"+id));
   
     employee.setFirstName( employeeDetails.getFirstName());
     employee.setLastName( employeeDetails.getLastName());
     employee.setEmailId( employeeDetails.getEmailId());
     
     Employee UpdateEmployee = employeeRepository.save( employee);
     return ResponseEntity.ok(UpdateEmployee);
		
	}
	 
	// Delete Employee
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isEmpty()) {
			throw new RuntimeException("no employee found with Id "+id);
		}
		employeeRepository.delete(employeeOptional.get());
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
	}

}
