package com.mvn.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mvn.courseapi.model.Course;
import com.mvn.courseapi.model.Topic;
import com.mvn.courseapi.service.CourseResponse;
import com.mvn.courseapi.service.CourseService;


import java.util.List;

@RestController
@RequestMapping("/courseapi")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable Long id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }
    
    
    @PostMapping("/topics/{topicId}/courses")
	public ResponseEntity<CourseResponse> addCourse(@RequestBody Course course, @PathVariable Long topicId){
    	CourseResponse courseResponse = new CourseResponse();
    	courseResponse.setCourse(course);
    	
    	course.setTopic(new Topic(topicId,"",""));
    	
    	boolean isCourseAdded = courseService.addCourse(course);
		
				if(!isCourseAdded) {
			courseResponse.setMessage("Course:"+course.getName()+" already exists.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(courseResponse);
		}
				
		
		courseResponse.setMessage("Course:"+course.getName()+" added successfully.");
		return ResponseEntity.status(HttpStatus.CREATED).body(courseResponse);		
	}
	


    @PutMapping("/topics/{topicId}/courses/{id}")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody Course course, @PathVariable Long topicId, @PathVariable Long id) {
        course.setTopic(new Topic(topicId, "",""));
        courseService.updateCourse(course);
        
        CourseResponse courseResponse = new CourseResponse();
    	courseResponse.setCourse(course);
    	courseResponse.setMessage("Course has been updated successfully.");
			
				
		return ResponseEntity.status(HttpStatus.CREATED).body(courseResponse);	
		
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}