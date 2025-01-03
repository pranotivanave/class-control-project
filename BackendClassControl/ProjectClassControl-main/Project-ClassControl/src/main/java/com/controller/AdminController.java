package com.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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

import com.dao.StudentRepository;
import com.dao.TeacherRepository;
import com.dto.ClassroomCreateRequest;
import com.dto.ClassroomUpdateRequest;
import com.dto.StudentCourseRequest;
import com.model.Admin;
import com.model.Classroom;
import com.model.Course;
import com.model.Student;
import com.model.Teacher;
import com.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	/*****************************************************************************************************************************/

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		Admin registeredAdmin = adminService.registerAdmin(admin);
		return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
	}

	/**************************************************************************************************************************/

	@PostMapping("/course/create")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course savedCourse = adminService.createCourse(course);
		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}

	@PutMapping("/course/update")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		Course updatedCourse = adminService.updateCourse(course);
		return new ResponseEntity<>(updatedCourse, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/course/delete/{id}")
	public ResponseEntity<Course> deleteCourseById(@PathVariable("id") int courseId) {
		Course courseToDelete = new Course();
		courseToDelete.setCourse_Id(courseId);
		Course deletedCourse = adminService.deleteCourse(courseToDelete);
		return new ResponseEntity<>(courseToDelete, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getAllCourses")
   	public ResponseEntity<List<Course>> getAllCourses() {
        	List<Course> courses = adminService.getAllCourse();
        	return ResponseEntity.ok(courses);
   	}
	
	/**************************************************************************************************************************/

	@GetMapping("/getAllClassrooms")
	public ResponseEntity<List<Classroom>> getAllClassrooms() {
	        List<Classroom> classrooms = adminService.getAllClassrooms();
	        return ResponseEntity.ok(classrooms);
	}
	
	@PostMapping("/classroom/create")
	public ResponseEntity<Classroom> createClassroom(@RequestBody ClassroomCreateRequest request) {
		Classroom newClassroom = adminService.createClassroom(request.getCourseId(), request.getTeacherId(),
				request.getClassroomName(), request.getClassroomDescription());
		return ResponseEntity.ok(newClassroom);
	}

	@PutMapping("/classroom/update")
	public ResponseEntity<Classroom> updateClassroom(@RequestBody ClassroomUpdateRequest updateRequest) {
		Classroom updatedClassroom = adminService.updateClassroom(updateRequest.getClassroomId(),
				updateRequest.getTeacherId(), updateRequest.getClassroomName(),
				updateRequest.getClassroomDescription());
		return ResponseEntity.ok(updatedClassroom);
	}

	@DeleteMapping("/classroom/delete/{id}")
	public ResponseEntity<String> deleteClassroom(@PathVariable int id) {
		adminService.deleteClassroom(id);
		String message = "Classroom with ID " + id + " has been successfully deleted.";
		return ResponseEntity.ok().body(message);
	}

	/********************************************************************************************************************************/
	
	@Autowired
	private TeacherRepository teacherRepository;

	@GetMapping("/getAllTeachers")
    	public ResponseEntity<List<Teacher>> getAllTeachers() {
        	List<Teacher> teachers = adminService.getAllTeachers();
        	return ResponseEntity.ok(teachers);
    	}
	
	
	
	@PostMapping("/generatePasswordForTeacher/{teacherId}")
	public ResponseEntity<String> generatePasswordForTeacher(@PathVariable int teacherId) {
		try {
			adminService.generatePasswordForTeacher(teacherId);
			return ResponseEntity.ok("Password generated successfully for teacher with ID: " + teacherId);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/admin/addTeacherToCourse")
	public ResponseEntity<String> addTeacherToCourse(@RequestBody Map<String, Integer> request) {
		int teacherId = request.get("teacherId");
		int courseId = request.get("courseId");

		try {
			adminService.addTeacherToCourse(teacherId, courseId);
			return ResponseEntity.ok("Teacher added to course successfully.");
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/course/{courseId}/teacher/{teacherId}")
	public ResponseEntity<String> removeTeacherFromCourse(@PathVariable int courseId, @PathVariable int teacherId) {
		try {
			adminService.removeTeacherFromCourse(teacherId, courseId);
			return ResponseEntity.ok("Teacher removed from course successfully.");
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/admin/sendTeacherCredentials/{teacherId}")
    	public ResponseEntity<String> sendTeacherCredentials(@PathVariable int teacherId) {
        	Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        		if (optionalTeacher.isPresent()) {
        			adminService.sendTeacherLoginCredentials(optionalTeacher.get());
            		return ResponseEntity.ok("Teacher login credentials sent successfully to." );
        		} 
			else {
            			throw new NoSuchElementException("Teacher not found with ID: " + teacherId);
        		     }		
    	}

	
	/**************************************************************************************************************************/

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/getAllStudents")
    	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = adminService.getAllStudents();
	        return ResponseEntity.ok(students);
	}
	
	
	
	@PostMapping("/generatePasswordForStudent/{studentId}")
	public ResponseEntity<String> generatePasswordForStudent(@PathVariable int studentId) {
		try {
			adminService.generatePasswordForStudent(studentId);
			return ResponseEntity.ok("Password generated successfully for student with ID: " + studentId);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/admin/addStudentToCourse")
	public ResponseEntity<String> addStudentToCourse(@RequestBody StudentCourseRequest request) {
        	try {
            		adminService.addStudentToCourse(request);
            		return ResponseEntity.ok("Student added to course successfully");
        	    }		 
		catch (NoSuchElementException e) {
            		return ResponseEntity.status(404).body("Student or course not found");
        	} 
		catch (Exception e) {
            		return ResponseEntity.status(500).body("An error occurred");
        	}
    	}

	 @PostMapping("/admin/removeStudentFromCourse/{student_Id}")
	 public ResponseEntity<String> removeStudentFromCourse(@PathVariable int student_Id) {
	        adminService.removeStudentFromCourse(student_Id);
	        return ResponseEntity.ok("Student removed from course successfully.");
	 }

	 @PostMapping("/admin/sendStudentCredentials/{student_Id}")
	 public ResponseEntity<String> sendStudentCredentials(@PathVariable int student_Id) {
	        Optional<Student> optionalStudent = studentRepository.findById(student_Id);
	        if (optionalStudent.isPresent()) {
	        	adminService.sendStudentLoginCredentials(optionalStudent.get());
	        	return ResponseEntity.ok("Student login credentials sent successfully to." );
	        } else {
	            throw new NoSuchElementException("Student not found with ID: " + student_Id);
	        }
	}
}
