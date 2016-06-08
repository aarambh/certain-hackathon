package com.certainhackathon.common.services;

import com.certainhackathon.common.exceptions.NotFoundException;
import com.certainhackathon.common.model.BaseModel;
import com.certainhackathon.common.repositories.AbstractRepository;

public abstract class AbstractServiceImpl<T extends BaseModel> implements AbstractService<T>{

	public abstract AbstractRepository<T> getRepository();
	
	public T create(T dto) {
    	if (dto != null) {
    		throw new NotFoundException("Unable to create object.");
    	}
    	
    	return null;
    }
    
    public T update(T dto) {
    	if (dto != null) {
    		throw new NotFoundException("Unable to update object.");
    	}
    	
    	return null;
    }
    
    public T findById(String id){
    	if(id == null){
    		throw new NotFoundException("id cannot be null");
    	}
    	return getRepository().findOne(id);
    }
    
       
	public void delete(String id) {
		T entity = getRepository().findOne(id);
		
		if (entity != null) {
			getRepository().delete(id);
		}
	}
	
}
