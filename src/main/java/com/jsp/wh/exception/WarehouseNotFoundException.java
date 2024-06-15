package com.jsp.wh.exception;

public class WarehouseNotFoundException extends RuntimeException {
	
	private String messgae;

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public WarehouseNotFoundException(String messgae) {
		super();
		this.messgae = messgae;
	}
	

}
