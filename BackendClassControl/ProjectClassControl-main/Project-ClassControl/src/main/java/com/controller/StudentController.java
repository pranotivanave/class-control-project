package com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Classroom;
import com.model.Material;
import com.model.Student;
import com.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		Student newStudent = studentService.registerStudent(student);
		return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
	}

	@GetMapping("/{studentId}/studentGetClassrooms")
	public List<Classroom> getClassroomsForStudent(@PathVariable int studentId) {
		return studentService.getClassroomsForStudent(studentId);
	}

	@GetMapping("/classrooms/{classroomId}/studentGetClassroomMaterials")
	public ResponseEntity<List<Material>> getMaterialsByClassroomId(@PathVariable int classroomId) {
		List<Material> materials = studentService.getMaterialsByClassroomId(classroomId);
		return new ResponseEntity<>(materials, HttpStatus.OK);
	}

	@GetMapping("/classrooms/{classroomId}/material/{materialId}/studentdownload")
	public ResponseEntity<byte[]> downloadMaterial(@PathVariable int classroomId, @PathVariable int materialId) {
		Material material = studentService.getMaterialById(materialId);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + material.getMaterial_Title() + "\"");

		return ResponseEntity.ok().headers(headers).body(material.getMaterial_File());
	}

	@GetMapping("/{assignmentId}/studentDownloadAssignedAssignment")
	public ResponseEntity<byte[]> downloadAssignedAssignment(@PathVariable int assignmentId) {
		return studentService.downloadAssignedAssignment(assignmentId);
	}

	
	@PostMapping("/{assignmentId}/studentSubmitAssignment")
	public ResponseEntity<String> uploadCompletedAssignment(@RequestParam("file") MultipartFile file, @PathVariable int assignmentId) {
		   try {
		        studentService.uploadCompletedAssignment(file, assignmentId);
		        return ResponseEntity.ok("Assignment submitted successfully.");
		    } 
		    catch (IllegalArgumentException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assignment not found with id: " + assignmentId);
		    } 
		    catch (IOException e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the uploaded file.");
		    }
	}

	@DeleteMapping("/studentDeleteSubmittedAssignment/{submission_Id}")
        public ResponseEntity<String> deleteSubmittedAssignment(@PathVariable int submission_Id) {
		try {
	        	studentService.deleteSubmittedAssignment(submission_Id);
	            return ResponseEntity.ok("Submission deleted successfully with ID: " + submission_Id);
	        } 
		catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        } 
		catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete submission.");
	        }
    	}
}
