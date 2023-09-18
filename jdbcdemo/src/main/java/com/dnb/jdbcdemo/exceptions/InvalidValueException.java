package com.dnb.jdbcdemo.exceptions;

public class InvalidValueException extends Exception{
	
	public InvalidValueException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return super.toString()+ super.getMessage();
	}
	
}
