package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	 
    @Query("SELECT t FROM Teacher t WHERE t.teacher_Email = :teacher_Email")
    Teacher findByTeacher_Email(String teacher_Email);

}
