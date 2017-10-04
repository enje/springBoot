package io.javabrains.springbootstarter.courses;

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
public class CourseService {
	
	//for db
	@Autowired
	private CourseRepository courseRepository;
	
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Fromaework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "JavaScript", "JavaScript Description")
	));*/
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		//filter based on topic associated with course
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
	}
	
	public Course getCourse(String id){
		//java 8 way to find first topic with correct id
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course){
		//topics.add(topic);
		courseRepository.save(course);
	}
	
	public void updateCourse(String id, Course course){
		//could also use "topics.stream().filter(t -> t.getId().equals(id)).findFirst().get;" again
		/*for (int i = 0; i < topics.size(); i++){
			Topic t = topics.get(i);
			if (t.getId().equals(id)){
				topics.set(i,  topic); //update topic once found
				return;
			}
		}*/
		
		//overwrites Topic object if it already exists
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id){
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.delete(id);
	}
}
