package io.javabrains.springbootstarter.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//data layer
//for database queries (CRUD), abstracted by Spring Data JPA
public interface CourseRepository extends CrudRepository<Course, String>{
	
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
	//now we can work with all the CRUD method
	
	//follows the pre-defined findByProperty convention!
	public List<Course> findByTopicId(String topicId);
}
