package com.evoke.studentmanagementsystem.service;

import java.util.List;

import com.evoke.studentmanagementsystem.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudent();
	
	public Student saveStudent(Student student);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student);
	
	public void deleteStudentById(Long id);
	

}
