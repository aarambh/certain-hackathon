package com.certainhackathon.common.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.certainhackathon.common.model.BaseModel;

public interface AbstractRepository<T extends BaseModel> extends MongoRepository<T, String>, QueryDslPredicateExecutor<T>{

}
