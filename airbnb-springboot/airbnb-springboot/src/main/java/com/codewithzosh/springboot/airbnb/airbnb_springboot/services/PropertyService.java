package com.codewithzosh.springboot.airbnb.airbnb_springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.Property;

public interface PropertyService {

	//create property and return it by using id
	Property createProperty(Property property);
	// get all properties
	List<Property> getAllProperties();
	// retrieve all properties owned by the specific user through userId
	List<Property> getAllPropertyOfUser(Long userId);
	// get property by id
	Property getPropertyById(Long id);
	// update property by id
	Property updateProperty(Long id,Property latestProperty);
	// delete property by id
	void deleteProperty(Long id);
	
}
