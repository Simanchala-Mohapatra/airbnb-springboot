package com.codewithzosh.springboot.airbnb.airbnb_springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.entities.User;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.jwt.JwtUtils;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.repositories.UserRepo;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(String username, String password, String email, String fullName, String phoneNumber) {
        String encryptedPassword = passwordEncoder.encode(password);
        User user = new User(username, encryptedPassword, email, fullName, phoneNumber);
        userRepository.save(user);
    }


    
    public String authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateTokenFromUsername(user.getUsername());
        }
        throw new RuntimeException("Invalid username or password");
    }
    
}

