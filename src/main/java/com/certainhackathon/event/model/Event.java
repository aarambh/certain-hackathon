package com.certainhackathon.event.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.certainhackathon.common.model.BaseModel;

@Document(collection="events")
public class Event extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1551516635321057412L;
	String eventName;
	String eventCode;
	String location;
	String createdBy;
	List<String> availableTimeSlots;
	List<AvailableDates> availableDates;
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
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<String> getAvailableTimeSlots() {
		return availableTimeSlots;
	}
	public void setAvailableTimeSlots(List<String> availableTimeSlots) {
		this.availableTimeSlots = availableTimeSlots;
	}
	
	public List<AvailableDates> getAvailableDates() {
		return availableDates;
	}
	public void setAvailableDates(List<AvailableDates> availableDates) {
		this.availableDates = availableDates;
	}
	public void setId(String id) {
		this._id = id;
	}
	@Override
	@Id
	public String getId() {
		return _id;
	}

}
