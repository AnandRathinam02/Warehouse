package com.jsp.wh.exception;

public class WarehouseNotFoundByIdException  extends RuntimeException {
	private String messaage;

	public WarehouseNotFoundByIdException(String messaage) {
		super();
		this.messaage = messaage;
	}

}
