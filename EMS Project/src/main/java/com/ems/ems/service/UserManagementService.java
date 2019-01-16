package com.ems.ems.service;

import com.ems.ems.Domain.User;

public interface UserManagementService {

	void resendPassword(User user);

	void verifyResetPasswordToken(User user, String token);

	void updatePassword(User user, String password);

}
