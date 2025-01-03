package com.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.model.Classroom;
import com.model.Material;
import com.model.Student;

public interface StudentService {
	
	public Student registerStudent(Student student);

	public List<Classroom> getClassroomsForStudent(int studentId);
	
	public List<Material> getMaterialsByClassroomId(int classroomId);
	
	public Material getMaterialById(long materialId);
	
	public ResponseEntity<byte[]> downloadAssignedAssignment(int assignmentId);
	
	public ResponseEntity<String> uploadCompletedAssignment(MultipartFile file, int assignmentId) throws IOException;
	
	public void deleteSubmittedAssignment(int submission_Id);
}
