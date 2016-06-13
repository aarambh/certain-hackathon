package com.certainhackathon.calendar.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.certainhackathon.common.model.BaseModel;

@Document
public class UserCalendar extends BaseModel implements Serializable{

	private static final long serialVersionUID = -1059715097518329505L;

	public void setId(String id) {
		this._id = id;
	}

	@Override
	@Id
	public String getId() {
		return _id;
	}

}
