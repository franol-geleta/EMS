package com.ems.ems.service;

import com.ems.ems.Domain.User;

public interface RegistrationService {
	User startRegistration(User user);

	User continueRegistration(User user, String token);

	boolean isRegistrationCompleted(User user);
}
