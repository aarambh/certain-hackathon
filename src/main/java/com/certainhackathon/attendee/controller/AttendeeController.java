package com.certainhackathon.attendee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.certainhackathon.attendee.model.Attendee;
import com.certainhackathon.attendee.services.AttendeeService;
import com.certainhackathon.common.controller.AbstractController;

@RestController
@RequestMapping("/attendee")
public class AttendeeController extends AbstractController{

	@Autowired
	AttendeeService attendeeService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void postAttendee(@RequestBody Attendee attendee){
		attendeeService.create(attendee);
	}
	
}
