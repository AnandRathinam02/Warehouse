package com.jsp.wh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int addreessId;
	private  String addressLine ;
	private  String  city;
	private  String  state;
	private  String country;
	private   int   pincode;
	private  String longitude;
	private  String latitude;
	@OneToOne
	private Warehouse warehouse;
	public int getAddreessId() {
		return addreessId;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public int getPincode() {
		return pincode;
	}
	public String getLongitude() {
		return longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setAddreessId(int addreessId) {
		this.addreessId = addreessId;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
 
	
 
}
