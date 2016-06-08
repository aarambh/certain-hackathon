package com.certainhackathon.common.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public abstract class BaseModel {

	public ObjectId _id;
	public abstract ObjectId getId();
}
