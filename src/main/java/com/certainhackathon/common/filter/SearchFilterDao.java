package com.certainhackathon.common.filter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.certainhackathon.common.model.BaseModel;

public interface SearchFilterDao<T extends BaseModel, E extends SearchFilter> {
	
	Page<T> findByFilter(E filter, Pageable pageble);
}
