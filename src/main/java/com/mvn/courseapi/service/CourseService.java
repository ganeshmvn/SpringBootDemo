package com.mvn.courseapi.service;

import java.util.List;

import com.mvn.courseapi.model.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	
	 public List<Course> getAllCourses(Long topicId);

	    public Course getCourse(Long id) ;

	    public boolean addCourse(Course course) ;

	    public void updateCourse(Course course) ;

	    public void deleteCourse(Long id);
}
