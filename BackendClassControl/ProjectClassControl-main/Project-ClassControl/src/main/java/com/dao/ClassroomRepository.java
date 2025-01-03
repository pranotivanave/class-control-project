package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Classroom;
import com.model.Course;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
	
	List<Classroom> findByCourse(Course course);

	@Query("SELECT c FROM Classroom c WHERE c.teacher.teacher_Id = :teacherId")
	List<Classroom> findClassroomsByTeacherId(@Param("teacherId") int teacherId);
}
