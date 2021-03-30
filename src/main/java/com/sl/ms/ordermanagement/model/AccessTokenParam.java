package com.sl.ms.ordermanagement.model;

public class AccessTokenParam {

	String username;
	String password;

	public AccessTokenParam() {
	}

	public AccessTokenParam(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
