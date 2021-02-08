package com.demo;
//What is the use of usebean tags

//remove BL from jsp and put into a pojo ie pojo is called jsp beans

public class User {
	private String username;
	private String password;
	private boolean valid;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername is called");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setPassword is called");
		this.password = password;
	}

	public boolean getValid() {
		// db code ...
		if (username.equals(password))
			return true;
		else
			return false;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public User(String username, String password, boolean valid) {
		this.username = username;
		this.password = password;
		this.valid = valid;
	}

	public User() {}

}
