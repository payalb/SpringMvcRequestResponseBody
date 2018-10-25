package com.java.exception;


public class InvalidUserException extends RuntimeException{

	private static final long serialVersionUID = 7022438755038615430L;

	public InvalidUserException(String message) {
		super(message);
	}
}
