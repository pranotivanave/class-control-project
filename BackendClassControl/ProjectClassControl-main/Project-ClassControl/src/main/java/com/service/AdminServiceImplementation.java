package com.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminRepository;
import com.dao.ClassroomRepository;
import com.dao.CourseRepository;
import com.dao.StudentRepository;
import com.dao.TeacherRepository;
import com.dto.StudentCourseRequest;
import com.model.Admin;
import com.model.Classroom;
import com.model.Course;
import com.model.Student;
import com.model.Teacher;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private NotificationService notificationService;

	/****************************************************************************************************************************************
	 * Admin Registration 
	 *****************************************************************************************************************************************/

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin registerAdmin(Admin admin) {
		Admin newAdmin = new Admin();
		newAdmin.setAdmin_FullName(admin.getAdmin_FullName());
		newAdmin.setAdmin_MobileNo(admin.getAdmin_MobileNo());
		newAdmin.setAdmin_Username(admin.getAdmin_Username());
		newAdmin.setAdmin_Password(admin.getAdmin_Password());

		return adminRepository.save(newAdmin);

	}

	/*********************************************************************************************************************************************
	 * Course Creation, Updation and Deletion By Admin:
	 *********************************************************************************************************************************************/

	@Autowired
	private CourseRepository courseRepository;

	

	@Override
	public Course createCourse(Course course) {
		Course newCourse = new Course();
		newCourse.setCourse_Name(course.getCourse_Name());
		newCourse.setCourse_Description(course.getCourse_Description());
		return courseRepository.save(newCourse);
	}

	public Course updateCourse(Course updatedCourse) {
		Course existingCourse = courseRepository.findById(updatedCourse.getCourse_Id())
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + updatedCourse.getCourse_Id()));

		if (updatedCourse.getCourse_Name() != null) {
			existingCourse.setCourse_Name(updatedCourse.getCourse_Name());
		}
		if (updatedCourse.getCourse_Description() != null) {
			existingCourse.setCourse_Description(updatedCourse.getCourse_Description());
		}

		return courseRepository.save(existingCourse);
	}

	@Override
	public Course deleteCourse(Course course) {
		Course existingCourse = courseRepository.findById(course.getCourse_Id())
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + course.getCourse_Id()));

		courseRepository.deleteById(existingCourse.getCourse_Id());

		return existingCourse;
	}

	@Override
	public List<Course> getAllCourse() {

		return courseRepository.findAll();
	}

	
	/*********************************************************************************************************************************************
	 * Classroom Creation, Updation and Deletion
	 ********************************************************************************************************************************************/

	@Autowired
	private ClassroomRepository classroomRepository;

	

	@Override
	@Transactional
	public Classroom createClassroom(int courseId, int teacherId, String classroomName, String classroomDescription) {

		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new NoSuchElementException("Course not found with id " + courseId));
		Teacher teacher = teacherRepository.findById(teacherId)
				.orElseThrow(() -> new NoSuchElementException("Teacher not found with id " + teacherId));

		Classroom newClassroom = new Classroom();

		newClassroom.setCourse(course);
		newClassroom.setTeacher(teacher);
		newClassroom.setClassroom_Name(classroomName);
		newClassroom.setClassroom_Description(classroomDescription);

		return classroomRepository.save(newClassroom);
	}

	@Override
	@Transactional
	public Classroom updateClassroom(int classroomId, int teacherId, String classroomName,
			String classroomDescription) {
		Classroom classroom = classroomRepository.findById(classroomId)
				.orElseThrow(() -> new NoSuchElementException("Classroom not found with id " + classroomId));

		Teacher teacher = teacherRepository.findById(teacherId)
				.orElseThrow(() -> new NoSuchElementException("Teacher not found with id " + teacherId));

		classroom.setTeacher(teacher);
		classroom.setClassroom_Name(classroomName);
		classroom.setClassroom_Description(classroomDescription);

		return classroomRepository.save(classroom);
	}

	@Override
	@Transactional
	public void deleteClassroom(int classroomId) {
		Classroom classroom = classroomRepository.findById(classroomId)
				.orElseThrow(() -> new NoSuchElementException("Classroom not found with id " + classroomId));
		classroomRepository.delete(classroom);
	}

	@Override
	public List<Classroom> getAllClassrooms() {

		return classroomRepository.findAll();
	}
	

	/*********************************************************************************************************************************************
	 * Generate Password, Send Credentials, Add & Remove Teacher From Course
	 *********************************************************************************************************************************************/

	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	
	@Override
	public void generatePasswordForTeacher(int teacherId) {
		Teacher teacher = new Teacher();
		Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
		if (optionalTeacher.isPresent()) {
			teacher = optionalTeacher.get();
			String password = PasswordGenerator.generateRandomPassword(8);
			teacher.setTeacher_Password(password);
			teacherRepository.save(teacher);
		} else {
			throw new NoSuchElementException("Teacher with specified id " + teacher.getTeacher_Id() + " not found.");
		}

	}

	@Override
	public void addTeacherToCourse(int teacherId, int courseId) {
		Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		if (optionalTeacher.isPresent() && optionalCourse.isPresent()) {
			Teacher teacher = optionalTeacher.get();
			Course course = optionalCourse.get();
			teacher.getCourse().add(course);// Set the course for the teacher
			teacherRepository.save(teacher);
		} else {
			throw new NoSuchElementException("Teacher or course not found.");
		}
	}

	@Transactional
	public void removeTeacherFromCourse(int teacherId, int courseId) {
		Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
		Optional<Course> optionalCourse = courseRepository.findById(courseId);

		if (optionalTeacher.isPresent() && optionalCourse.isPresent()) {
			Teacher teacher = optionalTeacher.get();
			Course course = optionalCourse.get();

			// Force initialization of collections
			teacher.getCourse().size();
			course.getTeacher().size();

			// Debugging output
			System.out.println("Teacher Courses: " + teacher.getCourse());
			System.out.println("Course Teachers: " + course.getTeacher());

			// Check if the teacher is assigned to the course
			if (teacher.getCourse().contains(course)) {
				// Remove the course from the teacher's list of courses
				teacher.getCourse().remove(course);
				// Remove the teacher from the course's list of teachers
				course.getTeacher().remove(teacher);

				// Save both entities to update the relationship in the database
				teacherRepository.save(teacher);
				courseRepository.save(course);
			} else {
				throw new NoSuchElementException("Teacher is not assigned to the course.");
			}
		} else {
			throw new NoSuchElementException("Teacher or course not found.");
		}
	}

	@Override
	public void sendTeacherLoginCredentials(Teacher teacher) {
		String to = teacher.getTeacher_Email();
		String subject = "Your Class Control Login Credentials";
		String body = "Dear " + teacher.getTeacher_FullName() + ",\n\n"
				+ "Your login credentials to Class Control are as follows:\n" + "Username: "
				+ teacher.getTeacher_Email() + "\n" + "Password: " + teacher.getTeacher_Password() + "\n"
				+ "Login Link: http://example.com/login\n\n" + "Best regards,\nYour Team Class Control";

		notificationService.sendEmail(to, subject, body);
		
	}

	

	/**************************************************************************************************************************************************
	 * Generate Password, Send Credentials, Add & Remove Student From Course
	 **************************************************************************************************************************************************/

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void generatePasswordForStudent(int studentId) {
		Student student = new Student();
		Optional<Student> optionalStudent = studentRepository.findById(studentId);

		if (optionalStudent.isPresent()) {
			student = optionalStudent.get();
			String password = PasswordGenerator.generateRandomPassword(8);
			student.setStudent_Password(password);
			studentRepository.save(student);
		} else {
			throw new NoSuchElementException("Student with specified id " + student.getStudent_Id() + " not found.");
		}
	}

	@Transactional
	public void addStudentToCourse(StudentCourseRequest request) {
		int student_Id = request.getStudent_Id();
		int course_Id = request.getCourse_Id();

		Student student = studentRepository.findById(student_Id)
				.orElseThrow(() -> new NoSuchElementException("Student not found with ID: " + student_Id));

		Course course = courseRepository.findById(course_Id)
				.orElseThrow(() -> new NoSuchElementException("Course not found with ID: " + course_Id));

		student.setCourse(course);
		studentRepository.save(student);
	}

	@Transactional
	public void removeStudentFromCourse(int studentId) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new NoSuchElementException("Student not found with ID: " + studentId));

		student.setCourse(null);
		studentRepository.save(student);
	}

	

	@Override
	public void sendStudentLoginCredentials(Student student) {
		String to = student.getStudent_Email();
		String subject = "Your Class Control Login Credentials";
		String body = "Dear " + student.getStudent_Email() + ",\n\n"
				+ "Your login credentials to Class Control are as follows:\n" + "Username: "
				+ student.getStudent_Email() + "\n" + "Password: " + student.getStudent_Password() + "\n"
				+ "Login Link: http://example.com/login\n\n" + "Best regards,\nYour Team Class Control";

		notificationService.sendEmail(to, subject, body);
		
	}

	
}
