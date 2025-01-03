package com.service;

import java.util.List;

import com.dto.StudentCourseRequest;
import com.model.Admin;
import com.model.Classroom;
import com.model.Course;
import com.model.Student;
import com.model.Teacher;

public interface AdminService {

	// method for admin registration

	public Admin registerAdmin(Admin admin);

	// methods for managing courses:

	public Course createCourse(Course course);

	public Course updateCourse(Course course);

	public Course deleteCourse(Course course);

	List<Course> getAllCourse();

	

	// methods for managing classrooms

	public Classroom createClassroom(int courseId, int teacherId, String classroomName, String classroomDescription);

	public Classroom updateClassroom(int classroomId, int teacherId, String classroomName, String classroomDescription);

	public void deleteClassroom(int classroomId);

	List<Classroom> getAllClassrooms();

	

	// methods for managing teacher:

	public void generatePasswordForTeacher(int teacherId);

	public void addTeacherToCourse(int teacherId, int courseId);

	public void removeTeacherFromCourse(int teacherId, int courseId);

	public void sendTeacherLoginCredentials(Teacher teacher);

	public List<Teacher> getAllTeachers();

	
	// methods for managing student:

	List<Student> getAllStudents();

	public void generatePasswordForStudent(int studentId);

	public void addStudentToCourse(StudentCourseRequest request);

	public void removeStudentFromCourse(int studentId);

	public void sendStudentLoginCredentials(Student student);

}
