package com.evoke.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

	public static void main(String[] args) {
		List<Employee> empList = getEmpDetails("D://csv//emp.csv");
		for (Employee emp : empList) {
			System.out.println(emp);
		}

	}

	private static List<Employee> getEmpDetails(String file) {

		List<Employee> empList = new ArrayList<>();
		Path pathToFile = Paths.get(file);
		try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
			String row = br.readLine();
			while (row != null) {
				String[] attributes = row.split(",");
				Employee emp = getOneEmployee(attributes);
				empList.add(emp);
				row = br.readLine();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return empList;
	}

	private static Employee getOneEmployee(String[] attributes) {
		int id = Integer.parseInt(attributes[0]);
		String firstName = attributes[1];
		String lastName = attributes[2];
		String email = attributes[3];
		String gender = attributes[4];
		int salary = Integer.parseInt(attributes[5]);

		Employee emp = new Employee(id, firstName, lastName, email, gender, salary);
		return emp;
	}

}
