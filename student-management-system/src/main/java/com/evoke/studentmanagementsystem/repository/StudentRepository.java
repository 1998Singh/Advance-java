package com.evoke.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evoke.studentmanagementsystem.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
