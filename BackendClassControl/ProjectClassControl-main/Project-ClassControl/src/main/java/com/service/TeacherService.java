
package com.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Classroom;
import com.model.Teacher;

public interface TeacherService {

	public Teacher registerTeacher(Teacher teacher);
	
	List<Classroom> getClassroomsByTeacherId(int teacherId);
	
	public void uploadMaterial(MultipartFile file, int classroom_Id) throws IOException;
	
	public void deleteMaterial(Long material_Id);
	
	public void assignAssignment(MultipartFile file, int classroomId, String assignmentTitle, LocalDateTime deadline) throws IOException;
	
	public void extendAssignmentDeadline(int assignmentId, LocalDateTime newDeadline);
}
