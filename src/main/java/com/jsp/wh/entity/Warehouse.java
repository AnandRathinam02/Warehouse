package com.jsp.wh.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
	private int warehouseId;
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
