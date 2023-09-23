package com.dnb.DevConnector.exceptions;

public class InvalidPasswordException extends Exception{
	public InvalidPasswordException(String msg)
	{
		super(msg);
	}
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	
}
}
