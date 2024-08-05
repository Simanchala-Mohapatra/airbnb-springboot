package com.codewithzosh.springboot.airbnb.airbnb_springboot.exceptions;

public class PropertyNotFoundException extends RuntimeException {

	public PropertyNotFoundException(String message) {
		super(message);
	}
	
}
