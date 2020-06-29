package com.mvn.courseapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvn.courseapi.model.Course;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    public List<Course> getCourseByName(String name);

    public List<Course> findById(Long id);
    
    public List<Course> findByTopicId(Long topicId);

    public List<Course> getCourseByTopic(Long topicId);
}