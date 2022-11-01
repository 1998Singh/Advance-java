package com.evoke.springboottesting.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.Core;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.evoke.springboottesting.model.Employee;
import com.evoke.springboottesting.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EmployeeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private ObjectMapper objectMapping;
	
	
	// jUnit Test for getAllEmployee Method
	 @DisplayName("jUnit Test for getAllEmployee Method")
	 @Test
	public void givenListOfEmployee_whenGetAllEmployee_thenReturnEmployeeList() throws Exception{
		//given
		List<Employee> listOfEmployee = new ArrayList<>();
		Employee employee = new Employee("Abhit", "Sinha", "siha@gmail.com");
		Employee employee1 = new Employee("Rishabh", "Singh", "singh@gmail.com");
		BDDMockito.given(employeeService.getAllEmployee()).willReturn(listOfEmployee);
		
		// when
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/employee"));
		
		// then - verify the output
		response.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.size()", 
				CoreMatchers.is(listOfEmployee.size())));
	}
    
	 
	 // JUnit Test for Post Method
	@DisplayName("JUnit test for post method")
	@Test
	public void givenEmployeeObject_whenCreateEmployee_thenreturnEmployee() throws Exception {
        	
		// given-> setup
		Employee employee = new Employee("Abhit", "Sinha", "siha@gmail.com");
		BDDMockito.given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class)))
				.will((invocation) -> invocation.getArgument(0));
		
		// when
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapping.writeValueAsString(employee)));

		// then
         response.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employee.getEmail())));

	}

}
