package com.calapp.model.service;

public class User {
	private String username;
	private String password;
	private String profile;
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public User(String username, String password, String profile) {
		this.username = username;
		this.password = password;
		this.profile = profile;
	}
	public User() {}
	
	
	
}
