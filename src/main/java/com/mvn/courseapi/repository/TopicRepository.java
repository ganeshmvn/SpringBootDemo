package com.mvn.courseapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mvn.courseapi.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {
	public List<Topic> findByName(String name);
}
