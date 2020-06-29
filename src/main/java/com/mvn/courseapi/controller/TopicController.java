package com.mvn.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvn.courseapi.model.Topic;
import com.mvn.courseapi.service.TopicResponse;
import com.mvn.courseapi.service.TopicService;

@RestController
@RequestMapping("/courseapi")
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Long id) {
		return topicService.getTopic(id);
	}

	@PostMapping("/topics/")
	public ResponseEntity<TopicResponse> addTopic(@RequestBody Topic topic) {
		TopicResponse topicResponse = new TopicResponse();
		topicResponse.setTopic(topic);
		
		boolean isTopicAdded = topicService.addTopic(topic);
		
		if(!isTopicAdded) {
			topicResponse.setMessage("Topic:"+topic.getName()+" already exists.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(topicResponse);
		}
		topicResponse.setMessage("Topic:"+topic.getName()+" added successfully.");
		return ResponseEntity.status(HttpStatus.CREATED).body(topicResponse);		
	}
	
	
	@PutMapping("/topics/{id}")
	public ResponseEntity<TopicResponse> updateTopic(@RequestBody Topic topic, @PathVariable Long id) {
		
		TopicResponse topicResponse = new TopicResponse();
		
		topicService.updateTopic(id, topic);
		topicResponse.setMessage("Topic has been updated successfully.");
		topicResponse.setTopic(topic);		
				
		return ResponseEntity.status(HttpStatus.CREATED).body(topicResponse);	
		
	}
	
	
	@DeleteMapping("/topics/{id}")
	public String deleteTopic(@PathVariable Long id) {
		topicService.deleteTopic(id);
		String response = "{\"success\": true, \"message\": Topic has been deleted successfully.}";
		return response;
	}
}
