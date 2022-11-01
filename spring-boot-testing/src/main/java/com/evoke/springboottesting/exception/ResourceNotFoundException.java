package com.evoke.springboottesting.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String massage) {
		super(massage);
	}

	
	public ResourceNotFoundException(String massage, Throwable cause) {
		super(massage, cause);
	}

}
