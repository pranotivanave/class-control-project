package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Classroom;
import com.model.Material;
import com.model.Teacher;
import com.service.TeacherService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping("/teacher/register")
	public ResponseEntity<Teacher> regsiterTeacher(@RequestBody Teacher teacher) {
		Teacher newTeacher = teacherService.registerTeacher(teacher);
		return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
	}

	@GetMapping("/teachers/{teacherId}/classrooms")
	public ResponseEntity<List<Classroom>> getClassroomsByTeacherId(@PathVariable int teacherId) {
		List<Classroom> classrooms = teacherService.getClassroomsByTeacherId(teacherId);
		return ResponseEntity.ok(classrooms);
	}

	@PostMapping("/teacher/uploadNotes")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("classroom_Id") int classroom_Id) {
		try {
			teacherService.uploadMaterial(file, classroom_Id);
			return ResponseEntity.ok().body("File uploaded successfully");
		} catch (IOException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
		}
	}

	@DeleteMapping("/teacher/deleteUploadedNotes/{materialId}")
	public ResponseEntity<String> deleteMaterial(@PathVariable Long materialId) {
		try {
			teacherService.deleteMaterial(materialId);
			return ResponseEntity.ok("Material deleted successfully.");
		} 
		catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Material not found with id: " + materialId);
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete material.");
		}
	}

	@PostMapping("/classrooms/{classroomId}/teacherAssignAssignment")
	public ResponseEntity<String> assignAssignment(@RequestParam("file") MultipartFile file,
			@PathVariable int classroomId, @RequestParam String assignmentTitle, @RequestParam String deadline) {
		try {
			LocalDateTime deadlineDateTime = LocalDateTime.parse(deadline); // Assuming deadline is in ISO-8601 format
			teacherService.assignAssignment(file, classroomId, assignmentTitle, deadlineDateTime);
			return ResponseEntity.status(HttpStatus.CREATED).body("Assignment assigned successfully.");
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to assign assignment.");
		}
	}

	@PutMapping("/teacherExtendAssignmentDeadline/{assignmentId}")
	public ResponseEntity<String> extendAssignmentDeadline(@PathVariable int assignmentId,
			@RequestParam String newDeadline) {

		try {
			LocalDateTime newDeadlineDateTime = LocalDateTime.parse(newDeadline, DateTimeFormatter.ISO_DATE_TIME);
			teacherService.extendAssignmentDeadline(assignmentId, newDeadlineDateTime);
			return ResponseEntity.ok("Assignment deadline extended successfully.");
		} 
		catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assignment not found with id: " + assignmentId);
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to extend assignment deadline.");
		}
	}
}
