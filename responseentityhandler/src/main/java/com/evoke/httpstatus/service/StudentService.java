package com.evoke.httpstatus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.evoke.httpstatus.dao.StudentRepository;
import com.evoke.httpstatus.model.Students;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

//	private static List<Students> list = new ArrayList<Students>();
//
//	static {
//		list.add(new Students(1, "Akash Singh", "PCM"));
//		list.add(new Students(2, "Arun Singh", "PCB"));
//		list.add(new Students(3, "Abhit Sinha", "Automobile"));
//		list.add(new Students(4, "Sagar kumar", "CSE"));
//	}

	// getting List of all Student
	public List<Students> getAllStudents() {
		List<Students> list = (List<Students>) this.studentRepository.findAll();
		return list;
	}

	// getting student details by rollNo
	public Students getStudentByRollno(int rollNo) {
//		for (Students student : list) {
//			if (student.getRollNo() == rollNo) {
//				return student;}}
		Students students = null;
		students = this.studentRepository.findByRollNo(rollNo);
		return students;
	}

	// adding new Student detail in list
	public Students addStudent(Students student) {
//		list.add(student);
//		return student;
		Students result = studentRepository.save(student);
		return result;
	}

	// Deleting student from list
	public void deleteStudent(int rollNo) {
//list = list.stream().filter(student -> student.getRollNo() != rollNo).collect(Collectors.toList());
         
		studentRepository.deleteById(rollNo);
	}

}
