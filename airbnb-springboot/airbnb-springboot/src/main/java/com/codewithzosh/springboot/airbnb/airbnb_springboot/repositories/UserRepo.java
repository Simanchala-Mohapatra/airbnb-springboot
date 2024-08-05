package com.codewithzosh.springboot.airbnb.airbnb_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
