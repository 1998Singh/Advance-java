package com.evoke.springboottesting.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.evoke.springboottesting.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	// JUnite test for Save employee operation
	@DisplayName("Junit test for save employee operation")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSaveEmployee() {

		// given - setup
		Employee employee = new Employee("Ramesh", "Singh", "ramesh@gmail.com");

		// when - action or behavior u r going to test
		Employee saveEmployee = employeeRepository.save(employee);

		// then - verify the output
		assertThat(saveEmployee).isNotNull();
		assertThat(saveEmployee.getId()).isGreaterThan(0);

	}
	
	
	@DisplayName("Junit test for get all employee operation")
	@Test
	public void givenEmployeeList_whenFindAll_thenEmployeesList() {

		// given - setup
		Employee employee = new Employee("Ramesh", "Singh", "ramesh@gmail.com");
		Employee employee1= new Employee("Ram", "Singh", "ram@gmail.com");
		employeeRepository.save(employee);
		employeeRepository.save(employee1);

		// when - action or behavior u r going to test
		List<Employee> employeelist = employeeRepository.findAll();

		// then - verify the output
		assertThat(employeelist).isNotNull();
		assertThat(employeelist.size()).isGreaterThan(1);

	}
	
	@DisplayName("Junit test for get employee by email operation")
	@Test
	public void givenEmployeeEmail_whenFindByEmail_thenEmployeeObject() {

		// given - setup
		Employee employee = new Employee("Ramesh", "Sharma", "shrama@gmail.com");
		employeeRepository.save(employee);

		// when - action or behavior u r going to test
		Employee employee3 = employeeRepository.findByEmail(employee.getEmail()).get();

		// then - verify the output
		assertThat(employee3).isNotNull();
		

	}
	


}
