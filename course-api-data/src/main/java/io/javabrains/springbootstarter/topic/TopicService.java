package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

//we make a Spring business service. Not needed, but good to have to expedite workload
//of the Controller.
@Service
public class TopicService {
	
	//for db
	@Autowired
	private TopicRepository topicRepository;
	
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Fromaework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "JavaScript", "JavaScript Description")
	));*/
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		return topics;
	}
	
	public Topic getTopic(String id){
		//java 8 way to find first topic with correct id
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic){
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic){
		//could also use "topics.stream().filter(t -> t.getId().equals(id)).findFirst().get;" again
		/*for (int i = 0; i < topics.size(); i++){
			Topic t = topics.get(i);
			if (t.getId().equals(id)){
				topics.set(i,  topic); //update topic once found
				return;
			}
		}*/
		
		//overwrites Topic object if it already exists
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id){
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}
}
