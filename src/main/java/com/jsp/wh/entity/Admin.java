package com.jsp.wh.entity;

import java.util.List;

import com.jsp.wh.enums.AdminType;
import com.jsp.wh.enums.Privilege;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String name ;
	private String email ;
	private String password ;
	@Enumerated(EnumType.STRING)
	private AdminType adminType;
	 
	public int getAdminId() {
		return adminId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public AdminType getAdminType() {
		return adminType;
	}
	 
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAdminType(AdminType adminType) {
		this.adminType = adminType;
	}
	 
	
	 
	
	 
	


}
