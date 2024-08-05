package com.codewithzosh.springboot.airbnb.airbnb_springboot.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
