package com.fedex.jps.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//this interface that will use the spring JPA interface will provide the class
//  is used to contain all the methods that interact with the DB
public interface CourseRepository extends CrudRepository <Course, String> {

	// now make your custom methods here
	//findSOMETHING"By""a field"
	public List<Course> getCoursesByTopic(String topicId);
	
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String desc);
	
	
	public List<Course> findByTopicId(String topicId);
	
	//these normal type methods are all included in the CrudRepository
	//  so, there is no need to build them again

	
	
}
