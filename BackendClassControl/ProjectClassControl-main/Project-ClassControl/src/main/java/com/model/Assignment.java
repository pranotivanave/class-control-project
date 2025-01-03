package com.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignment_Id;

	private String assignment_Title;
	private LocalDateTime assignment_Deadline;

	@OneToMany(mappedBy = "assignment")
	private List<Material> material;

	@OneToMany(mappedBy = "assignment")
	private List<Submission> submissions;

	
	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;
	

	public Assignment() {
		super();
		
	}

	public Assignment(int assignment_Id, String assignment_Title, LocalDateTime assignment_Deadline
		,Classroom classroom	, List<Material> material, List<Submission> submissions) {
		super();
		this.assignment_Id = assignment_Id;
		this.assignment_Title = assignment_Title;
		this.assignment_Deadline = assignment_Deadline;
		this.classroom=classroom;
		
		this.material = material;
		this.submissions = submissions;
	}

	public int getAssignment_Id() {
		return assignment_Id;
	}

	public void setAssignment_Id(int assignment_Id) {
		this.assignment_Id = assignment_Id;
	}

	public String getAssignment_Title() {
		return assignment_Title;
	}

	public void setAssignment_Title(String assignment_Title) {
		this.assignment_Title = assignment_Title;
	}

	public LocalDateTime getAssignment_Deadline() {
		return assignment_Deadline;
	}

	public void setAssignment_Deadline(LocalDateTime assignment_Deadline) {
		this.assignment_Deadline = assignment_Deadline;
	}

	public List<Material> getMaterialEntity() {
		return material;
	}

	public void setMaterialEntity(List<Material> material) {
		this.material = material;
	}

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}	

}
