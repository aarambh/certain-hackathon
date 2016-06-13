package com.certainhackathon.event.services;

import java.util.List;

import com.certainhackathon.common.services.AbstractService;
import com.certainhackathon.event.model.Event;

public interface EventService extends AbstractService<Event> {

	List<Event> findAll();

}
