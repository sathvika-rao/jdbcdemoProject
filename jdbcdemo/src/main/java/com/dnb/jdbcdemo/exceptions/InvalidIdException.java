package com.dnb.jdbcdemo.exceptions;

public class InvalidIdException extends Exception{

	public InvalidIdException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return super.toString() + super.getMessage();
	}
	
}
