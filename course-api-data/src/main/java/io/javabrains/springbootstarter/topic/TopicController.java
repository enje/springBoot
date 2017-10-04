package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//anything returned automatically converted to JSON
@RestController
public class TopicController {
	
		//mark topicService as something that need dependency injection
		@Autowired
		private TopicService topicService;
	
		//get all topics. RequestMapping default method is GET
		@RequestMapping("/topics")
		public List<Topic> getAllTopics(){
			return topicService.getAllTopics();
		}
		
		//get one topic by id
		@RequestMapping("/topics/{id}")
		public Topic getTopic(@PathVariable String id){
			return topicService.getTopic(id);
		}
		
		//this takes a pull request
		@RequestMapping(method=RequestMethod.POST, value="/topics")
		public void addTopic(@RequestBody Topic topic){
			topicService.addTopic(topic);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
		public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
			topicService.updateTopic(id, topic);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
		public void deleteTopic(@PathVariable String id){
			topicService.deleteTopic(id);
		}
}
