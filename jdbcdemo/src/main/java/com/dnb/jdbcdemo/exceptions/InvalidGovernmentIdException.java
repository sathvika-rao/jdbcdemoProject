package com.dnb.jdbcdemo.exceptions;

public class InvalidGovernmentIdException extends Exception {

	public InvalidGovernmentIdException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return super.toString() + super.getMessage();
	}
	
}
