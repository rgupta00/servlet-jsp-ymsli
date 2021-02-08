package com.customerapp.dao;

public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7843949554760027657L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}