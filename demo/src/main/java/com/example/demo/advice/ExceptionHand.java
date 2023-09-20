package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionHand {

	@ExceptionHandler(UserNotFoundException.class)
	public ApiResponse handleExcep(UserNotFoundException userNotFoundException)
	{
		ApiResponse response= ApiResponse.builder().status(false).status2(HttpStatus.BAD_REQUEST).msg(userNotFoundException.getMessage()).build();
		return response;
	}
}
