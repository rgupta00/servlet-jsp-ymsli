package com.iris.bookapp.model.persistance.user;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -2048016409478265725L;

	public UserNotFoundException(String message) {
		super(message);
	}

	
}
