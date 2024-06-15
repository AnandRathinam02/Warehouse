package com.jsp.wh.exception;

public class ClientNotFoundByIdException extends RuntimeException {
	private  String message;

	public String getMessage() {
		return message;
	}

	public ClientNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	

}
