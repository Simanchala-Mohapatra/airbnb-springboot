package com.codewithzosh.springboot.airbnb.airbnb_springboot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	LocalDateTime timeStamp;
	String message;
	String description;
	
}
