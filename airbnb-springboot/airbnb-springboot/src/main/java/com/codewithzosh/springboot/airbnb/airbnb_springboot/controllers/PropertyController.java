package com.codewithzosh.springboot.airbnb.airbnb_springboot.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.dto.ApiResponse;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.Property;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.services.PropertyService;

@RestController
@RequestMapping("/api")
public class PropertyController {

	PropertyService propertyService;
	
	public PropertyController(PropertyService propertyService) {
		this.propertyService=propertyService;
	}
	
//	@Autowired
//	private PropertyService propertyService;
	
	// POST /api/properties -> create properties
	@PostMapping("/properties")
	public ResponseEntity<Property> createProperty(@RequestBody Property property)
	{
		Property createdProperty = propertyService.createProperty(property);
		return new ResponseEntity<>(createdProperty,HttpStatus.CREATED);
	}
	
	// GET /api/properties -> retrieve all properties
	@GetMapping("/properties")
	public ResponseEntity<List<Property>> retrieveAllProperties()
	{
		List<Property> allProperties = propertyService.getAllProperties();
		return new ResponseEntity<>(allProperties,HttpStatus.OK);
	}
	
	// GET /api/properties/{id} -> get property by id
	@GetMapping("/properties/{id}")
	public ResponseEntity<Property> getPropertyId(@PathVariable Long id)
	{
		Property retrievedProperty = propertyService.getPropertyById(id);
		return new ResponseEntity<Property>(retrievedProperty,HttpStatus.OK);
	}
	
	// PUT /api/properties/{id} -> update property
	@PutMapping("/properties/{id}")
	public ResponseEntity<Property> updateProperty( @PathVariable Long id, @RequestBody Property property)
	{
		Property updatedProperty = propertyService.updateProperty(id, property);
		return new ResponseEntity<Property>(updatedProperty,HttpStatus.OK);
	}
	
	
	// DELETE /api/properties/{id} -> delete property
	@DeleteMapping("/properties/{id}")
	public ResponseEntity<ApiResponse> deleteProperty(@PathVariable Long id)
	{
		propertyService.deleteProperty(id);
		ApiResponse response=new ApiResponse(true, "Successfully Deleted Property Having Id:"+id);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	// GET /api/users/{userId}/properties -> Returns all properties owned by the specified user.
	@GetMapping("/users/{userId}/properties")
	public ResponseEntity<List<Property>> retrieveAllOwnedProperties(@PathVariable Long userId)
	{
		List<Property> allPropertyOfUser = propertyService.getAllPropertyOfUser(userId);
		return new ResponseEntity<>(allPropertyOfUser,HttpStatus.OK);
	}
	
}
