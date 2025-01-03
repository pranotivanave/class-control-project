package com.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Submission {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int submission_Id;
	
	private LocalDateTime submissionDateTime;
	
	@Column(length=1000000)
	@Lob
	private byte[] assignment_SubmissionFile;
	    

  	@ManyToOne
   	@JoinColumn(name = "student_id")
    	private Student student;

    	@ManyToOne
    	@JoinColumn(name = "assignment_id")
        private Assignment assignment;

	public Submission() {
		super();
		    
	}
	
	public Submission(int submission_Id, LocalDateTime submissionDateTime, byte[] assignment_SubmissionFile,
				Student student, Assignment assignment) {
		super();
		this.submission_Id = submission_Id;
		this.submissionDateTime = submissionDateTime;
		this.assignment_SubmissionFile = assignment_SubmissionFile;
		this.student = student;
		this.assignment = assignment;
	}

   	public int getSubmission_Id() {
		return submission_Id;
	}

	public void setSubmission_Id(int submission_Id) {
		this.submission_Id = submission_Id;
	}

	public LocalDateTime getSubmissionDateTime() {
		return submissionDateTime;
	}

	public void setSubmissionDateTime(LocalDateTime submissionDateTime) {
		this.submissionDateTime = submissionDateTime;
	}

	public byte[] getAssignment_SubmissionFile() {
		return assignment_SubmissionFile;
	}

	public void setAssignment_SubmissionFile(byte[] assignment_SubmissionFile) {
		this.assignment_SubmissionFile = assignment_SubmissionFile;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}	

}
