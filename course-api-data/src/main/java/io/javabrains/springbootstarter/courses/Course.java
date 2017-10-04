package io.javabrains.springbootstarter.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.springbootstarter.topic.Topic;


@Entity //for database
public class Course {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	//we need to associate each course with a topic
	//foreign key, there can be MANY courses for ONE topic
	@ManyToOne
	private Topic topic;
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	public Course(){
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
