package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

//data layer
//for database queries (CRUD), abstracted by Spring Data JPA
public interface TopicRepository extends CrudRepository<Topic, String>{
	
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
	//now we can work with all the CRUD method
	
}
