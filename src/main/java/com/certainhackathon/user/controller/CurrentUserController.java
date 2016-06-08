package com.certainhackathon.user.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.certainhackathon.user.model.User;

@RestController
@RequestMapping("/secure")
public class CurrentUserController {
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public User getUser(Principal principal){
		Authentication authentication = (Authentication) principal;
		if(authentication.getPrincipal() != null && authentication.getPrincipal() instanceof User){
			return (User)authentication.getPrincipal();
		}else{
			return null;
		}
	}
	
}
