package com.jsp.wh.exception;

public class SuperAdminAlreadyExistException extends RuntimeException{
 

	public SuperAdminAlreadyExistException(String message) {
	 
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
