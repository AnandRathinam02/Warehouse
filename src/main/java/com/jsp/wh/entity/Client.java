package com.jsp.wh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Client { 
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	   private int clientId; 
	   private String businessName; 
	   private String email; 
	   private long contactNumber; 
	   private String apikey;
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
	public String getApikey() {
		return apikey;
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
	public void setApikey(String apikey) {
		this.apikey = apikey;
	} 
	   
	    
	    
	}
