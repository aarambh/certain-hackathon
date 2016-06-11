package com.certainhackathon.common.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.certainhackathon.common.model.BaseModel;

public interface AbstractService<T extends BaseModel> {

	public T update(T model);
	
	public T create(T model);
	
	public void delete(String id);
	
	public Page<T> findByPage(Pageable pageable);
	
	public T findById(String id);
	
}
