package com.evoke.httpstatus.studentcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.httpstatus.model.Students;
import com.evoke.httpstatus.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	// Get All Students List
	@GetMapping("/students")
	public ResponseEntity<List<Students>> getstudent() {
		List<Students> list = studentService.getAllStudents();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	// View Student Details By id
	@GetMapping("/students/{rollNo}")
	public ResponseEntity<Students> getStudentByrollno(@PathVariable("rollNo") int rollNo) {
		Students student = studentService.getStudentByRollno(rollNo);
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(student));
	}

	// Adding New Student
	@PostMapping("/students")
	public ResponseEntity<Students> addStudent(@RequestBody Students student) {
		Students s1 = null;
		try {
			s1 = this.studentService.addStudent(student);
			System.out.println(student);
			return ResponseEntity.of(Optional.of(s1));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Delete book details by id
	@DeleteMapping("/students/{rollNo}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("rollNo") int rollNo) {
		try {
			this.studentService.deleteStudent(rollNo);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
