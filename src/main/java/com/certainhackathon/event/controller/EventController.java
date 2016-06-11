package com.certainhackathon.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.certainhackathon.common.controller.AbstractController;
import com.certainhackathon.event.model.Event;
import com.certainhackathon.event.services.EventService;

@RestController
@RequestMapping("/event")
public class EventController extends AbstractController {

	@Autowired
	EventService eventService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Event> getEvents(Pageable pageable){
		return eventService.findByPage(pageable);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void postEvent(@RequestBody Event event){
		eventService.create(event);
	}
	
	@RequestMapping("/{id}")
	public Event getEvent(@PathVariable String id){
		return eventService.findById(id);
	}
	
}
