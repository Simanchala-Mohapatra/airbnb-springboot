package com.codewithzosh.springboot.airbnb.airbnb_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> 
{

}
