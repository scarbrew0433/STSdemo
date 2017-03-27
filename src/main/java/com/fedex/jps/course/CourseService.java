package com.fedex.jps.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	//When spring creates an instance of the TopicService, it will also inject the topicRepository interface
	// into the TopicService
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId) {
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)  // get the cources related to a specific topic
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) { // pass JSON as a request OBJ ( POST )
		
		courseRepository.save(course);
	}
	
	public String updateCourse(Course course) {  //( PUT )
		courseRepository.save(course); // if row exists update it, else insert the row.
		return "UPDATED";

	}

	public String deleteCourse(String id) {
		courseRepository.delete(id);
		return "DELETED";
	}
	
	
	
	
	
}


