package com.certainhackathon.common.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.certainhackathon.common.model.BaseModel;

public abstract class AbstractRepositoryImpl<T extends BaseModel> {

	@Autowired
	MongoOperations mongoOperations;
	
	public abstract Sort getDefaultSortDir();
	
	public abstract List<T> doExtraFiltering(List<T> content);
	
	public Page<T> findAll(Criteria criteria, Class<T> clas, Pageable pageable){
		Query query = new Query(criteria);
		Long total = mongoOperations.count(query, clas);
		if(pageable.getSort() == null){
			query.with(getDefaultSortDir());
		}
		
		List<T> content = total > pageable.getOffset() 
				?  mongoOperations.find(query.with(pageable), clas)
				: Collections.<T> emptyList();
				
		return new PageImpl<T>(doExtraFiltering(content), pageable, total);
	}
	
	
}
