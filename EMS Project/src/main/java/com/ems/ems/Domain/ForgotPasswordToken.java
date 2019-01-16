package com.ems.ems.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "forgot_password_tokens")
public class ForgotPasswordToken extends TokenModel {

}
