package com.mvn.courseapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvn.courseapi.model.Topic;
import com.mvn.courseapi.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		return (List<Topic>) this.topicRepository.findAll();
	}

	public Topic getTopic(Long id) {
		return (Topic) this.topicRepository.findOne(id);
	}

	public boolean addTopic(Topic topic) {
		List<Topic> topicList = topicRepository.findByName(topic.getName());
		if (topicList.size() > 0) {
			return false;
		}

		this.topicRepository.save(topic);

		return true;

	}

	public void updateTopic(Long id, Topic topic) {
		this.topicRepository.save(topic);
	}

	public void deleteTopic(Long id) {
		this.topicRepository.delete(id);
	}
}
