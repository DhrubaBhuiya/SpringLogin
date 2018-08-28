package com.spring.controller;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


public class LoginBean {

	@NotEmpty(message="User name cannot be empty")
	private String userName;
	@NotEmpty(message="Password cannot be empty")
	@Pattern(regexp="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",message="Password format wrong")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
