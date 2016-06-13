package com.certainhackathon.common.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public abstract class BaseModel {

	public String _id;
	public abstract String getId();
}
