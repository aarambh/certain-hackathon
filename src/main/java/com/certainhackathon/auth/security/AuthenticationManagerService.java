package com.certainhackathon.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.certainhackathon.user.model.User;
import com.certainhackathon.user.repositories.UserRepository;

@Component
public class AuthenticationManagerService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("");
		return user;
	}

}
