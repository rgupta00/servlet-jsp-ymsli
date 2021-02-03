package com.iris.bookapp.model.persistance.user;

public class User {
	private String username;
	private String email;
	private String password;
	private String profile;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String email, String password, String profile) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
