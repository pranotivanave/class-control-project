package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long material_Id;

	private String material_Title;

	@Column(length = 1000000)
	@Lob
	private byte[] material_File;

	@Enumerated(EnumType.STRING)
	private MaterialType materialType;

	@ManyToOne
	@JoinColumn(name = "assignment_id")
	private Assignment assignment;

	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	public Material() {
		super();
	}

	public Material(Long material_Id, String material_Title, byte[] material_File, MaterialType materialType,
			Assignment assignment, Classroom classroom) {
		super();
		this.material_Id = material_Id;
		this.material_Title = material_Title;
		this.material_File = material_File;
		this.materialType = materialType;
		this.assignment = assignment;
		this.classroom = classroom;
	}

	public Long getMaterial_Id() {
		return material_Id;
	}

	public void setMaterial_Id(Long material_Id) {
		this.material_Id = material_Id;
	}

	public String getMaterial_Title() {
		return material_Title;
	}

	public void setMaterial_Title(String material_Title) {
		this.material_Title = material_Title;
	}

	public byte[] getMaterial_File() {
		return material_File;
	}

	public void setMaterial_File(byte[] material_File) {
		this.material_File = material_File;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

}
