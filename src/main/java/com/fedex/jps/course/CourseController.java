package com.fedex.jps.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.jps.topic.Topic;

@RestController
public class CourseController {

	@Autowired  //needs dependency injection
	private CourseService courseService; // the TopicService class will be avail for this controller
	
	@RequestMapping("/topics/{id}/courses") //GET is the default
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	
	
	@RequestMapping("/topics/{topicId}/courses/{id}") //GET is the default
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses") // explicit POST -- add a value
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) { // request payload contains JSON repesentaion of this OBJ
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}") // explicit PUT -- update a value
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id) { // request payload contains JSON repesentaion of this OBJ
		course.setTopic(new Topic(topicId, "", ""));
		String ret = courseService.updateCourse(course);
		System.out.println(ret);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}") //DELETE is the default
	public void deleteCourse(@PathVariable String id) {
		String ret =  courseService.deleteCourse(id);
		System.out.println(ret);
	}
	
}
