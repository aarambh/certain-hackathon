package com.certainhackathon.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Event> findByPage(){
		return eventService.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Event findOne(@PathVariable String id){
		return eventService.findById(id);
	}
}
