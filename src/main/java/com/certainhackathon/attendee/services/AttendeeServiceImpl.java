package com.certainhackathon.attendee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certainhackathon.attendee.model.Attendee;
import com.certainhackathon.attendee.repositories.AttendeeRepository;
import com.certainhackathon.common.repositories.AbstractRepository;
import com.certainhackathon.common.services.AbstractServiceImpl;

@Service
public class AttendeeServiceImpl extends AbstractServiceImpl<Attendee> implements AttendeeService {

	@Autowired
	AttendeeRepository attendeeRepository;
	
	@Override
	public AbstractRepository<Attendee> getRepository() {
		return attendeeRepository;
	}
	
	@Override
	public Attendee create(Attendee dto) {
		return attendeeRepository.save(dto);
	}

}
