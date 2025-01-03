package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Assignment;
import com.model.Material;
import com.model.Student;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

	@Query("SELECT m FROM Material m WHERE m.classroom.classroom_Id = :classroomId")
	List<Material> findByClassroomClassroomId(@Param("classroomId") int classroomId);

	@Query("SELECT m FROM Material m WHERE m.assignment = :assignment")
	Optional<Material> findByAssignment(@Param("assignment") Assignment assignment);
}
