package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}
