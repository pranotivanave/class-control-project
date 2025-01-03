package com.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_Id;

	private String course_Name;
	private String course_Description;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "course", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnore
	private List<Classroom> classroom;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Teacher> teacher;
	

	public Course()
	{
		super();
	}

	public Course(int course_Id, String course_Name, String course_Description, List<Classroom> classroom,
			List<Teacher> teacher) {
		super();
		this.course_Id = course_Id;
		this.course_Name = course_Name;
		this.course_Description = course_Description;
		this.classroom= classroom;
		
		this.teacher = teacher;
	}

	public int getCourse_Id() {
		return course_Id;
	}

	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}

	public String getCourse_Name() {
		return course_Name;
	}

	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}

	public String getCourse_Description() {
		return course_Description;
	}

	public void setCourse_Description(String course_Description) {
		this.course_Description = course_Description;
	}

	public List<Classroom> getClassroom() {
		return classroom;
	}

	public void setClassroom(List<Classroom> classroom) {
		this.classroom = classroom;
	}

	
	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	

}
