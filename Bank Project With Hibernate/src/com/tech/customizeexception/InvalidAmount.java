package com.tech.customizeexception;

public class InvalidAmount extends RuntimeException{
	
	public InvalidAmount(String s)
	{
		super(s);
	}

}
