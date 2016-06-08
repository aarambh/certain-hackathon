package com.certainhackathon.calendar.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.certainhackathon.calendar.services.UserCalendarService;
import com.certainhackathon.common.controller.AbstractController;

@RestController
public class UserCalendarController extends AbstractController {

	@Autowired
	UserCalendarService userCalendarService;
	
}
