package com.certainhackathon.event.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certainhackathon.common.repositories.AbstractRepository;
import com.certainhackathon.common.services.AbstractServiceImpl;
import com.certainhackathon.event.model.Event;
import com.certainhackathon.event.repositories.EventRepository;

@Service
public class EventServiceImpl extends AbstractServiceImpl<Event> implements
		EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	public Event create(Event model) {
		return eventRepository.save(model);
	}

	@Override
	public AbstractRepository<Event> getRepository() {
		return eventRepository;
	}

	@Override
	public List<Event> findAll() {
		List<Event> events = eventRepository.findAll();
		return events;
	}

}
