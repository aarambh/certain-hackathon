package com.certainhackathon.event.model;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.certainhackathon.common.model.BaseModel;

@Document
public class Event extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1551516635321057412L;
	String eventName;
	String eventCode;
	String location;
	List<Question> questions;
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void setId(ObjectId id) {
		this._id = id;
	}
	@Override
	@Id
	public ObjectId getId() {
		return _id;
	}

}
