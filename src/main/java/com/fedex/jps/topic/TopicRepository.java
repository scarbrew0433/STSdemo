package com.fedex.jps.topic;

import org.springframework.data.repository.CrudRepository;

//this interface that will use the spring JPA interface will provide the class
//  is used to contain all the methods that interact with the DB
public interface TopicRepository extends CrudRepository <Topic, String> {

	// now make your custom methods here
	//added custom method to find Topic by name using Crud
	public <List> void findByName(String name);
	
	//these normal type methods are all included in the CrudRepository
	//  so, there is no need to build them again
													//getAllTopics()
													//getTopic(id)
													//updateTopic(id)
													//deleteTopic()
}
