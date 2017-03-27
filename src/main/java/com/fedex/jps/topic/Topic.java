package com.fedex.jps.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //Tell DB that the table name is Topic, and will have 3 columns (i.e. id, name, description)
public class Topic {

	@Id // Tell DB that column id will be the primary key for the table
	private String id;
	private String name;
	private String description;
	
	
	public Topic() {

	}

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
