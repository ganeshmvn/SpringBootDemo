package com.mvn.courseapi.service;

import com.mvn.courseapi.model.Course;

public class CourseResponse {
	private Course course;
	private String message;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CourseResponse(Course course, String message) {
		super();
		this.course = course;
		this.message = message;
	}
	public CourseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
