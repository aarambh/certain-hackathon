package com.certainhackathon.common.services;

import com.certainhackathon.common.model.BaseModel;

public interface AbstractService<T extends BaseModel> {

	public T update(T model);
	
	public T create(T model);
	
	public void delete(String id);
	
	public T findById(String id);
	
}
