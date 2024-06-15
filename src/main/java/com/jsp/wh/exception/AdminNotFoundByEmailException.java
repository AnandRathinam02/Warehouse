package com.jsp.wh.exception;

public class AdminNotFoundByEmailException extends RuntimeException {
private String message;

public AdminNotFoundByEmailException(String message) {
	super();
	this.message = message;
}
}
