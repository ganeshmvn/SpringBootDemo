package com.mvn.courseapi.service;

import com.mvn.courseapi.model.Topic;

public class TopicResponse {
	private Topic topic;
	String message;
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TopicResponse(Topic topic, String message) {
		super();
		this.topic = topic;		
		this.message = message;
	}
	public TopicResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
