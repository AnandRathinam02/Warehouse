package com.jsp.wh.exception;

public class StorageNotFoundByIdException  extends RuntimeException{
	private String message;

	public StorageNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	

}
