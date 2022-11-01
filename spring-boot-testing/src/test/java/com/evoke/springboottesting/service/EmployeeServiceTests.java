package com.evoke.springboottesting.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.evoke.springboottesting.model.Employee;
import com.evoke.springboottesting.repository.EmployeeRepository;
import com.evoke.springboottesting.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EmployeeServiceTests {

	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
	private EmployeeServiceImpl employeeService;

	private Employee employee;

	@BeforeEach
	public void setup() {

		employee = new Employee("Rishabh", "Singh", "rsingh@gmail.com");
	}

	// JUnit test for saveEmployee method

	@DisplayName("JUnit test for saveEmployee method")
	@Test
	public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
		// given -setup
		given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
		given(employeeRepository.save(employee)).willReturn(employee);

		// when - action or behavior going to test
		Employee saveEmployee = employeeService.saveEmployee(employee);

		// then - verify the output
		assertThat(saveEmployee).isNotNull();
	}

	// JUnit test for getAllEmployee method

	@DisplayName("JUnit test for getAllEmployee method")
	@Test
	public void givenEmployeeList_whengetAllEmployee_thenReturnEmployeeList() {
		// given -setup
		Employee employee1 = new Employee("Tony", "Stark", "stark@gmail.com");
		given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));

		// when - action or behavior going to test
		List<Employee> employeeList = employeeService.getAllEmployee();

		// then - verify the output
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(2);
	}

	// JUnit Test for updateEmployee Method
	@DisplayName("JUnit Test for updateEmployee Method")
	@Test
	public void giveEmployeeObject_whenUpdateEmployee_thenReturnUpdateEmployee() {

		// given- precondition or setup
		given(employeeRepository.save(employee)).willReturn(employee);
		employee.setEmail("rishabhsingh@gmail.com");
		employee.setFirstName("Rishabh Kumar");

		// when - action or behavior
		Employee updateEmployee = employeeService.updateEmployee(employee);

		// then - verify the output
		assertThat(updateEmployee.getEmail()).isEqualTo("rishabhsingh@gmail.com");
		assertThat(updateEmployee.getFirstName()).isEqualTo("Rishabh Kumar");

	}

}
