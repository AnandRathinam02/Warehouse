package com.jsp.wh.responsedto;

public class ClientResponse { 
	 private int clientId; 
	 private String businessName; 
	 private String email; 
	 private long contactNumber;
	public int getClientId() {
		return clientId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public String getEmail() {
		return email;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
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
