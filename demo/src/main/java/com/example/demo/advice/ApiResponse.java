package com.example.demo.advice;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ApiResponse {
	
	 private Boolean status;
	 private HttpStatus status2;
	 private String msg;
}
