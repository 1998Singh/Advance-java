package com.evoke.studentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evoke.studentmanagementsystem.entity.Student;
import com.evoke.studentmanagementsystem.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired
	private StudentRepository studentrepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1= new Student( "Abhit", "Sinha", "sinha@gmail.com");
//		studentrepository.save(student1);
//		
//		Student student2= new Student( "Abhishek", "Saini", "saini@gmail.com");
//		studentrepository.save(student2);
//		
//		Student student3= new Student( "Rishabh", "Singh", "singh@gmail.com");
//		studentrepository.save(student3);
//		
//		Student student4= new Student( "Ragul", "Sinha", "sinha1@gmail.com");
//		studentrepository.save(student4);
		
		
	}
	

}
