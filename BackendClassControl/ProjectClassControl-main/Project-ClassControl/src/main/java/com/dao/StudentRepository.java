package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
    @Query("SELECT s FROM Student s WHERE s.student_Email = :student_Email")
    Student findByStudent_Email(String student_Email);
	
}
