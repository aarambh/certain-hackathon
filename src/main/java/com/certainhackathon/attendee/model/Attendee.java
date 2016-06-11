package com.certainhackathon.attendee.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.certainhackathon.common.model.BaseModel;

@Document
public class Attendee extends BaseModel implements Serializable {

	public static final long serialVersionUID = 6761262269242339596L;
	public enum Status {
		CONFIRMED, PENDING, REQUESTED
	}
	
	String email;
	String firstname;
	String lastname;
	Status status;
	String eventId;
	

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
