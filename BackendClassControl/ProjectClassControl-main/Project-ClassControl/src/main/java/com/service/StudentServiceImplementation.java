package com.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dao.AssignmentRepository;
import com.dao.MaterialRepository;
import com.dao.StudentRepository;
import com.dao.SubmissionRepository;
import com.model.Assignment;
import com.model.Classroom;
import com.model.Material;
import com.model.Student;
import com.model.Submission;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private SubmissionRepository submissionRepository;
	
	@Override
	public Student registerStudent(Student student) {
		Student newStudent = new Student();
		newStudent.setStudent_FullName(student.getStudent_FullName());
		newStudent.setStudent_BirthDate(student.getStudent_BirthDate());
		newStudent.setStudent_MobileNo(student.getStudent_MobileNo());
		newStudent.setStudent_Email(student.getStudent_Email());
		return studentRepository.save(newStudent);
	}


    public List<Classroom> getClassroomsForStudent(int studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return new ArrayList<>(student.getClassrooms());
        } else {
            throw new NoSuchElementException("Student not found.");
        }
    }
    
    public List<Material> getMaterialsByClassroomId(int classroomId) {
        return materialRepository.findByClassroomClassroomId(classroomId);
    }

    public Material getMaterialById(long materialId) {
        return materialRepository.findById(materialId)
                .orElseThrow(() -> new IllegalArgumentException("Material not found with id: " + materialId));
    }
    
    @Transactional
    public ResponseEntity<byte[]> downloadAssignedAssignment(int assignmentId) {
        // Retrieve the assigned assignment by ID
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with id: " + assignmentId));

        // Retrieve the material associated with the assignment
        Material material = materialRepository.findByAssignment(assignment)
                .orElseThrow(() -> new IllegalArgumentException("Material not found for assignment with id: " + assignmentId));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + material.getMaterial_Title() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(material.getMaterial_File());
    }

    @Transactional
    public ResponseEntity<String> uploadCompletedAssignment(MultipartFile file, int assignmentId) throws IOException {
        // Retrieve the assignment by ID
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with id: " + assignmentId));

        // Check if the deadline has not passed
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (currentDateTime.isAfter(assignment.getAssignment_Deadline())) {
            throw new IllegalStateException("Deadline for this assignment has passed. You cannot submit the assignment.");
        }

        // Process the file
        byte[] fileBytes = file.getBytes();

        // Save the completed assignment
        Submission submission = new Submission();
        submission.setAssignment(assignment);
        submission.setAssignment_SubmissionFile(fileBytes);
        submission.setSubmissionDateTime(LocalDateTime.now());
        submissionRepository.save(submission);

        // Return success message
        return ResponseEntity.ok("Assignment submitted successfully to assignment ID: " + assignmentId);
    }

    @Transactional
    public void deleteSubmittedAssignment(int submission_Id) {
        // Retrieve the submission by ID
        Submission submission = submissionRepository.findById(submission_Id)
                .orElseThrow(() -> new IllegalArgumentException("Submission not found with id: " + submission_Id));

        // Delete the submission
        submissionRepository.delete(submission);
    }
}
