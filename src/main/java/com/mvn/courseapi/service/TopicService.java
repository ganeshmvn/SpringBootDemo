package com.mvn.courseapi.service;

import java.util.List;

import com.mvn.courseapi.model.Topic;

public interface TopicService {
	
	public List<Topic> getAllTopics();

	public Topic getTopic(Long id);

	public boolean addTopic(Topic topic);

	public void updateTopic(Long id, Topic topic);

	public void deleteTopic(Long id);
}
