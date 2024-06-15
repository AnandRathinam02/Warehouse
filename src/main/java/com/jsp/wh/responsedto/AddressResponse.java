package com.jsp.wh.responsedto;

public class AddressResponse {
	private  int addreessId;
	public int getAddreessId() {
		return addreessId;
	}
	public void setAddreessId(int addreessId) {
		this.addreessId = addreessId;
	}
	private  String addressLine ;
	private  String  city;
	private  String  state;
	private  String country;
	private   int   pincode;
	private  String longitude;
	private  String latitude;
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
	public String getLogitude() {
		return longitude;
	}
	public String getLatitude() {
		return latitude;
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
	public void setLogitude(String logitude) {
		this.longitude = logitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
 
	
}
