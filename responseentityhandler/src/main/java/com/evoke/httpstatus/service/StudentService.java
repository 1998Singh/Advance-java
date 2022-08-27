package com.evoke.httpstatus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.evoke.httpstatus.model.Students;

@Component
public class StudentService {

	private static List<Students> list = new ArrayList<Students>();

	static {
		list.add(new Students(1, "Akash Singh", "PCM"));
		list.add(new Students(2, "Arun Singh", "PCB"));
		list.add(new Students(3, "Abhit Sinha", "Automobile"));
		list.add(new Students(4, "Sagar kumar", "CSE"));
	}

	// getting List of all Student
	public List<Students> getAllStudents() {
		return list;
	}

	// getting student details by rollNo
	public Students getStudentByRollno(int rollNo) {
		for (Students student : list) {
			if (student.getRollNo() == rollNo) {
				return student;
			}
		}
		return null;
	}

	// adding new Student detail in list
	public Students addStudent(Students student) {
		list.add(student);
		return student;
	}

	// Deleting student from list
	public void deleteStudent(int rollNo) {

		list = list.stream().filter(student -> student.getRollNo() != rollNo).collect(Collectors.toList());
	}

}
