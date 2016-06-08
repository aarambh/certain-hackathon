package com.certainhackathon.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.certainhackathon.common.controller.AbstractController;
import com.certainhackathon.user.model.User;
import com.certainhackathon.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController{

	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public User create(@RequestBody User user){
		user.setPassword(new Md5PasswordEncoder().encodePassword(user.getPassword(), null));
		user.setRole("ROLE_USER");
		return userService.create(user);
	}
	
	@RequestMapping(value="/activate/{activationLink}", method=RequestMethod.GET)
	public void activateAccount(@PathVariable String activationLink, HttpServletResponse response, HttpServletRequest request){
		userService.activateAccount(activationLink);
		try {
			response.sendRedirect(request.getScheme() + "://" + request.getServerName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
