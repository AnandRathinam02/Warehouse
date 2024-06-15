package com.jsp.wh.requestdto;

public class ClientRequest { 
	  
	 
	 private String businessName; 
	 private String email; 
	 private long contactNumber;
	public String getBusinessName() {
		return businessName;
	}
	public String getEmail() {
		return email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	 
	 
	}