package com.fedex.jps.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	//When spring creates an instance of the TopicService, it will also inject the topicRepository interface
	// into the TopicService
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>( Arrays.asList(
//			new Topic("spring", "Spring Framework", "SF Desc"),
//			new Topic("java", "Corejava", "Core java  Desc"),
//			new Topic("javaEE", "java EE", "java EE Desc")
//			));
	
	public List<Topic> getAllTopics() {
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		// return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) { // pass JSON as a request OBJ ( POST )
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public String updateTopic(Topic topic, String id) {  //( PUT )
		topicRepository.save(topic); // if row exists update it, else insert the row.
		return "UPDATED";
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if  (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return "UPDATED";
//			}
//		}
//		return "NOT UPDATED";	
	}

	public String deleteTopic(String id) {
		topicRepository.delete(id);
		return "DELETED";
//		topics.removeIf(t-> t.getId().equals(id));
//		return "DELETED";
	}
	
	
	
	
	
}


