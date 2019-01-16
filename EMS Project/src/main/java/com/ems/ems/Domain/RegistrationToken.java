package com.ems.ems.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registration_tokens")
public class RegistrationToken extends TokenModel {

}
