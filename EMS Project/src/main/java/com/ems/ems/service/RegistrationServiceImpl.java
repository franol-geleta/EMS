package com.ems.ems.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ems.ems.Domain.User;
import com.ems.ems.service.UserService;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserService userService;

	@Override
	public User startRegistration(User user) {
		User newUser = userService.saveUser(user);
		userService.setRegistrationCompleted(newUser);

		return newUser;
	}

	@Override
	public User continueRegistration(User user, String token) {
		return null;
	}

	@Override
	public boolean isRegistrationCompleted(User user) {
		return userService.isRegistrationCompleted(user);
	}

}
