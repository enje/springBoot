package io.javabrains.springbootstarter.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

//anything returned automatically converted to JSON
@RestController
public class CourseController {
	
		//mark topicService as something that need dependency injection
		@Autowired
		private CourseService courseService;
	
		//get all topics. RequestMapping default method is GET
		@RequestMapping("/topics/{id}/courses")
		public List<Course> getAllTopics(@PathVariable String id){
			return courseService.getAllCourses(id);
		}
		
		//get one topic by id
		@RequestMapping("/topics/{topicId}/courses/{id}")
		public Course getCourse(@PathVariable String id){
			return courseService.getCourse(id);
		}
		
		//this takes a pull request
		@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
		public void addCourse(@RequestBody Course course, @PathVariable String topicId){
			course.setTopic(new Topic(topicId, "", ""));
			courseService.addCourse(course);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
		public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
			course.setTopic(new Topic(topicId, "", ""));
			courseService.updateCourse(id, course);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
		public void deleteCourse(@PathVariable String id){
			courseService.deleteCourse(id);
		}
}
