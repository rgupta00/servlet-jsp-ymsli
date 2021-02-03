package com.iris.bookapp.model.persistance;

public class DataAccessExcetion extends RuntimeException{
	private static final long serialVersionUID = 346379755521396051L;

	public DataAccessExcetion(String message, Throwable cause) {
		super(message, cause);
	}

}
