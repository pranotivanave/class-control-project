package com.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dao.AssignmentRepository;
import com.dao.ClassroomRepository;
import com.dao.MaterialRepository;
import com.dao.TeacherRepository;
import com.model.Assignment;
import com.model.Classroom;
import com.model.Material;
import com.model.MaterialType;
import com.model.Teacher;


@Service
public class TeacherServiceImplementation implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher registerTeacher(Teacher teacher) {
		Teacher newTeacher = new Teacher();
		newTeacher.setTeacher_FullName(teacher.getTeacher_FullName());
		newTeacher.setTeacher_BirthDate(teacher.getTeacher_BirthDate());
		newTeacher.setTeacher_Email(teacher.getTeacher_Email());
		newTeacher.setTeacher_MobileNo(teacher.getTeacher_MobileNo());
		newTeacher.setTeacher_Expertise(teacher.getTeacher_Expertise());
		return teacherRepository.save(newTeacher);
	}

	@Override
	public List<Classroom> getClassroomsByTeacherId(int teacherId) {
		
		return classroomRepository.findClassroomsByTeacherId(teacherId);
	}
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;

	@Transactional
	public void uploadMaterial(MultipartFile file, int classroom_Id) throws IOException {
		// Validate file size, type, etc. (you may add validation logic here)

		// Retrieve the classroom by ID
		Classroom classroom = classroomRepository.findById(classroom_Id)
				.orElseThrow(() -> new IllegalArgumentException("Classroom not found with id: " + classroom_Id));

		// Process the file
		Material material = new Material();
		material.setMaterial_Title(StringUtils.cleanPath(file.getOriginalFilename()));
		material.setMaterial_File(file.getBytes());
		material.setMaterialType(MaterialType.NOTES);
		material.setClassroom(classroom);
		

		// Save the material
		materialRepository.save(material);
	}
	
	@Transactional
	public void deleteMaterial(Long material_Id) {
	    // Retrieve the material by ID
	    Material material = materialRepository.findById(material_Id)
	            .orElseThrow(() -> new IllegalArgumentException("Material not found with id: " + material_Id));

	    // Delete the material
	    materialRepository.delete(material);
	}


	@Transactional
	public void assignAssignment(MultipartFile file, int classroomId, String assignmentTitle, LocalDateTime deadline) throws IOException {
	    // Retrieve the classroom by ID
	    Classroom classroom = classroomRepository.findById(classroomId)
	            .orElseThrow(() -> new IllegalArgumentException("Classroom not found with id: " + classroomId));

	    // Process the file
	    byte[] fileBytes = file.getBytes();

	    // Save the assignment
	    Assignment assignment = new Assignment();
	    assignment.setAssignment_Title(assignmentTitle);
	    assignment.setAssignment_Deadline(deadline);
	    assignment.setClassroom(classroom);
	    assignmentRepository.save(assignment);

	    // Save the material
	    Material material = new Material();
	    material.setMaterial_Title(StringUtils.cleanPath(file.getOriginalFilename()));
	    material.setMaterial_File(fileBytes);
	    material.setMaterialType(MaterialType.ASSIGNMENT_MATERIAL);
	    material.setAssignment(assignment);
	    material.setClassroom(classroom);
	    materialRepository.save(material);
	}

	@Override
	public void extendAssignmentDeadline(int assignmentId, LocalDateTime newDeadline) {
		 Assignment assignment = assignmentRepository.findById(assignmentId)
	                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with id: " + assignmentId));

	        // Update the deadline
	        assignment.setAssignment_Deadline(newDeadline);

	        // Save the updated assignment
	       assignmentRepository.save(assignment);
	}

	

}
