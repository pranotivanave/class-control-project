package com.dto;

public class ClassroomCreateRequest {

	private Integer classroomId;
	private Integer courseId;
	private Integer teacherId;
	private String classroomName;
	private String classroomDescription;
	
	public Integer getClassroomId() {
		return classroomId;
	}
	
	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}
	
	public Integer getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getClassroomName() {
		return classroomName;
	}
	
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	
	public String getClassroomDescription() {
		return classroomDescription;
	}
	
	public void setClassroomDescription(String classroomDescription) {
		this.classroomDescription = classroomDescription;
	}
	
	
}
