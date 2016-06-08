package com.certainhackathon.user.repositories;

import com.certainhackathon.common.repositories.AbstractRepository;
import com.certainhackathon.user.model.User;

public interface UserRepository extends AbstractRepository<User> {

	User findByUsername(String username);

	User findByActivationLink(String activationLink);

}
