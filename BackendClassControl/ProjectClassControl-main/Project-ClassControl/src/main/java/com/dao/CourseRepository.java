package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	
}
