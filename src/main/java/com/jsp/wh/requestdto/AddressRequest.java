package com.jsp.wh.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressRequest {


	@NotNull( message = "  addressline should not be null")
	@NotBlank( message =  " addressline should not be blank")
	private  String addressLine ;

	@NotNull( message = "   city  should not be null")
	@NotBlank( message =  " city  should not be blank")
	private  String  city;

	@NotNull( message = "  state should not be null")
	@NotBlank( message =  " state should not be blank")
	private  String  state;

	@NotNull( message = "  state should not be null")
	@NotBlank( message =  " addressline should not be blank")
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
	public String getLongitude() {
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
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	 
	 
}
