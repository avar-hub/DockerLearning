package com.example.demo.exception;

import org.springframework.stereotype.Component;
public class UserNotFoundException extends RuntimeException{
 
	public UserNotFoundException(String msg)
	{
		super(msg);
	}
}
