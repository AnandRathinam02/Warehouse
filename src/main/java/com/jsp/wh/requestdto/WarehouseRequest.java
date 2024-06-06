package com.jsp.wh.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WarehouseRequest {
	
	
	private int warehouseId;
	
	@NotNull(message = "warehouse name must not to be null")
	@NotBlank( message =  "warehouse name not be blank")
	private String name ;
	public int getWarehouseId() {
		return warehouseId;
	}
	public String getName() {
		return name;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public void setName(String name) {
		this.name = name;
	}

}
