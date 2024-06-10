package com.jsp.wh.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
	private int warehouseId;
	private String name ;
	@OneToOne
	private  Admin admin;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	 
	 
	
	
}
