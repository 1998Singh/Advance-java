package com.evoke.studentmanagementsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evoke.studentmanagementsystem.entity.Student;
import com.evoke.studentmanagementsystem.repository.StudentRepository;
import com.evoke.studentmanagementsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

//	public StudentServiceImpl(StudentRepository studentRepository) {
//		super();
//		this.studentRepository = studentRepository;
//	}

	@Override
	public List<Student> getAllStudent() {

		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {

		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}

}
