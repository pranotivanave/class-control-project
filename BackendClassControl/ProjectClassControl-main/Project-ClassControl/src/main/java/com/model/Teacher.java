package com.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_Id;

	private String teacher_FullName;
	private String teacher_Email;
	private String teacher_MobileNo;
	private LocalDate teacher_BirthDate;
	private String teacher_Password;
	private String teacher_Expertise;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "course_teacher", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
	private List<Classroom> classroom;
	

	public Teacher() {
		super();

	}

	public Teacher(int teacher_Id, String teacher_FullName, String teacher_Email, String teacher_MobileNo,
			LocalDate teacher_BirthDate, String teacher_Password, String teacher_Expertise, List<Course> courses) {
		super();
		this.teacher_Id = teacher_Id;
		this.teacher_FullName = teacher_FullName;
		this.teacher_Email = teacher_Email;
		this.teacher_MobileNo = teacher_MobileNo;
		this.teacher_BirthDate = teacher_BirthDate;
		this.teacher_Password = teacher_Password;
		this.teacher_Expertise = teacher_Expertise;
		this.courses = courses;
	}

	public int getTeacher_Id() {
		return teacher_Id;
	}

	public void setTeacher_Id(int teacher_Id) {
		this.teacher_Id = teacher_Id;
	}

	public String getTeacher_FullName() {
		return teacher_FullName;
	}

	public void setTeacher_FullName(String teacher_FullName) {
		this.teacher_FullName = teacher_FullName;
	}

	public String getTeacher_Email() {
		return teacher_Email;
	}

	public void setTeacher_Email(String teacher_Email) {
		this.teacher_Email = teacher_Email;
	}

	public String getTeacher_MobileNo() {
		return teacher_MobileNo;
	}

	public void setTeacher_MobileNo(String teacher_MobileNo) {
		this.teacher_MobileNo = teacher_MobileNo;
	}

	public LocalDate getTeacher_BirthDate() {
		return teacher_BirthDate;
	}

	public void setTeacher_BirthDate(LocalDate teacher_BirthDate) {
		this.teacher_BirthDate = teacher_BirthDate;
	}

	public String getTeacher_Password() {
		return teacher_Password;
	}

	public void setTeacher_Password(String teacher_Password) {
		this.teacher_Password = teacher_Password;
	}

	public String getTeacher_Expertise() {
		return teacher_Expertise;
	}

	public void setTeacher_Expertise(String teacher_Expertise) {
		this.teacher_Expertise = teacher_Expertise;
	}

	public List<Course> getCourse() {
		return courses;
	}

	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

	public List<Classroom> getClassroom() {
		return classroom;
	}

	public void setClassroom(List<Classroom> classroom) {
		this.classroom = classroom;
	}

}
