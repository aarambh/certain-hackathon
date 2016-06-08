package com.certainhackathon.calendar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certainhackathon.calendar.model.UserCalendar;
import com.certainhackathon.calendar.repositories.UserCalendarRepository;
import com.certainhackathon.common.repositories.AbstractRepository;
import com.certainhackathon.common.services.AbstractServiceImpl;

@Service
public class UserCalendarServiceImpl extends AbstractServiceImpl<UserCalendar> implements UserCalendarService {

	@Autowired
	UserCalendarRepository userCalendarRepository;
	
	@Override
	public AbstractRepository<UserCalendar> getRepository() {
		return userCalendarRepository;
	}

}
