package com.certainhackathon.user.services;

import com.certainhackathon.common.services.AbstractService;
import com.certainhackathon.user.model.User;

public interface UserService extends AbstractService<User>{

	void activateAccount(String activationLink);
	
}
