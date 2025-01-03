package com.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_Id;

	private String student_FullName;
	private String student_Email;
	private String student_MobileNo;
	private LocalDate student_BirthDate;
	private String student_Password;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Classroom> classrooms;


   	@ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "course_id")
   	private Course course;
	
	public Student() {
		super();
	}

	public Student(int student_Id, String student_FullName, String student_Email, String student_MobileNo,
			LocalDate student_BirthDate, String student_Password, List<Classroom> classrooms, Course course) {
		super();
		this.student_Id = student_Id;
		this.student_FullName = student_FullName;
		this.student_Email = student_Email;
		this.student_MobileNo = student_MobileNo;
		this.student_BirthDate = student_BirthDate;
		this.student_Password = student_Password;
		this.classrooms = classrooms;
		this.course = course;
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public String getStudent_FullName() {
		return student_FullName;
	}

	public void setStudent_FullName(String student_FullName) {
		this.student_FullName = student_FullName;
	}

	public String getStudent_Email() {
		return student_Email;
	}

	public void setStudent_Email(String student_Email) {
		this.student_Email = student_Email;
	}

	public String getStudent_MobileNo() {
		return student_MobileNo;
	}

	public void setStudent_MobileNo(String student_MobileNo) {
		this.student_MobileNo = student_MobileNo;
	}

	public LocalDate getStudent_BirthDate() {
		return student_BirthDate;
	}

	public void setStudent_BirthDate(LocalDate student_BirthDate) {
		this.student_BirthDate = student_BirthDate;
	}

	public String getStudent_Password() {
		return student_Password;
	}

	public void setStudent_Password(String student_Password) {
		this.student_Password = student_Password;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}	
	
}
