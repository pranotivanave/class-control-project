package com.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classroom_Id;

	private String classroom_Name;
	private String classroom_Description;

	@ManyToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course course;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	@JsonIgnore
	private Teacher teacher;

	@ManyToMany
	@JoinTable(name = "classroom_student", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	@JsonIgnore
	private List<Student> students;

	public Classroom() {
		super();
		
	}

	public Classroom(int classroom_Id, String classroom_Name, String classroom_Description, Course course,
			Teacher teacher, List<Student> students) {
		super();
		this.classroom_Id = classroom_Id;
		this.classroom_Name = classroom_Name;
		this.classroom_Description = classroom_Description;
		this.course = course;
		this.teacher = teacher;
		this.students = students;
	}

	public int getClassroom_Id() {
		return classroom_Id;
	}

	public void setClassroom_Id(int classroom_Id) {
		this.classroom_Id = classroom_Id;
	}

	public String getClassroom_Name() {
		return classroom_Name;
	}

	public void setClassroom_Name(String classroom_Name) {
		this.classroom_Name = classroom_Name;
	}

	public String getClassroom_Description() {
		return classroom_Description;
	}

	public void setClassroom_Description(String classroom_Description) {
		this.classroom_Description = classroom_Description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
