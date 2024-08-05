package com.codewithzosh.springboot.airbnb.airbnb_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithzosh.springboot.airbnb.airbnb_springboot.dto.LoginRequest;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.dto.LoginResponse;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.dto.SignupRequest;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.jwt.JwtUtils;
import com.codewithzosh.springboot.airbnb.airbnb_springboot.services.AuthService;


@RestController
public class AuthController {


//	  @Autowired
//	    private JwtUtils jwtUtils;

//	    @Autowired
//	    private AuthenticationManager authenticationManager;
	
//	 @PostMapping("/api/auth/login")
//	    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//	        Authentication authentication;
//	        try {
//	            authentication = authenticationManager
//	                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//	        } catch (AuthenticationException exception) {
//	            Map<String, Object> map = new HashMap<>();
//	            map.put("message", "Bad credentials");
//	            map.put("status", false);
//	            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
//	        }
//
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//	        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);
//
//	        List<String> roles = userDetails.getAuthorities().stream()
//	                .map(item -> item.getAuthority())
//	                .collect(Collectors.toList());
//
//	        LoginResponse response = new LoginResponse(jwtToken,userDetails.getUsername(),roles);
//
//	        return ResponseEntity.ok(response);
//	    }
	 
	 @Autowired
	    private AuthService authService;

	    @PostMapping("/api/auth/signup")
	    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
	        authService.registerUser(request.getUsername(), request.getPassword(), request.getEmail(), request.getFullName(), request.getPhoneNumber());
	        return ResponseEntity.ok("User registered successfully");
	    }
	    
	    @PostMapping("/api/auth/login")
	    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
	        String token = authService.authenticateUser(request.getUsername(), request.getPassword());
	        return ResponseEntity.ok(new LoginResponse(token));
	    }
	
}
