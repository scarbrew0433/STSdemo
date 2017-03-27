package com.fedex.jps.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired  //needs dependency injection
	private TopicService topicService; // the TopicService class will be avail for this controller
	
	@RequestMapping("/topics") //GET is the default
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}") //GET is the default
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics") // explicit POST -- add a value
	public void addTopic(@RequestBody Topic topic) { // request payload contains JSON repesentaion of this OBJ
		topicService.addTopic(topic);
		
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}") // explicit PUT -- update a value
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) { // request payload contains JSON repesentaion of this OBJ
		String ret = topicService.updateTopic(topic, id);
		System.out.println(ret);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}") //DELETE is the default
	public void deleteTopic(@PathVariable String id) {
		String ret =  topicService.deleteTopic(id);
		System.out.println(ret);
	}
	
}
