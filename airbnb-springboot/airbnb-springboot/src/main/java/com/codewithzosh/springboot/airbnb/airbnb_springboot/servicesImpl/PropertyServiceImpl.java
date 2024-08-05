package com.codewithzosh.springboot.airbnb.airbnb_springboot.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.Property;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.User;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.exceptions.PropertyNotFoundException;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.exceptions.UserNotFoundException;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.repositories.PropertyRepo;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.repositories.UserRepo;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.services.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	PropertyRepo propertyRepo;
	
	UserRepo userRepo;
	
	public PropertyServiceImpl(PropertyRepo propertyRepo,UserRepo userRepo) {
		this.propertyRepo=propertyRepo;
		this.userRepo=userRepo;
	}
	
	@Override
	public Property createProperty(Property property) {
		Property savedProperty = propertyRepo.save(property);
		return savedProperty;
	}

	@Override
	public List<Property> getAllPropertyOfUser(Long userId) {

		User foundedUser = userRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User Not Found Having Id"+userId));
		List<Property> ownedProperties = foundedUser.getProperties();
		return ownedProperties;
	}

	@Override
	public Property getPropertyById(Long id) {
		Property property = propertyRepo.findById(id)
				.orElseThrow(()->new PropertyNotFoundException("Property Not Found With Id:"+id));
		return property;
	}

	@Override
	public Property updateProperty(Long id,Property latestProperty) {
		propertyRepo.findById(id).orElseThrow( ()->new  PropertyNotFoundException("Property Not Found With Id:"+id) );
		Property savedProperty = propertyRepo.save(latestProperty);
		return savedProperty;
	}

	@Override
	public void deleteProperty(Long id) {
		propertyRepo.findById(id).orElseThrow( ()->new  PropertyNotFoundException("Property Not Found With Id:"+id) );
		propertyRepo.deleteById(id);
		
	}

	@Override
	public List<Property> getAllProperties() {
		List<Property> properties = propertyRepo.findAll();
		return properties;
	}

}
