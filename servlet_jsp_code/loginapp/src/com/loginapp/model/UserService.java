package com.loginapp.model;

public class UserService {
	public static User getUser(String username, String password) {
		//i need the help of database
		if(username.equals(password)) {
			return new User(username, password, "emp");
		}else
			throw new UserNotFoundException("user with name :"+ username + " is not found");
	}
}
