package com.calapp.model.service;

public class UserService {
	public static User validateUser(String username, String password) {
		if(!username.equals(password))
			throw new UserNotFoundException("user "+ username +" is not found!");
		else
			return new User(username, password, "admin");
					
	}
}
