package com.model;

public class Dog {
	private String dogName;

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public Dog(String dogName) {
		this.dogName = dogName;
	}

	public Dog() {}
}
