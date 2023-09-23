package com.dnb.DevConnector.exceptions;

public class InvalidEmailException extends Exception{
	public InvalidEmailException(String msg)
	{
		super(msg);
	}
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	
}
}
