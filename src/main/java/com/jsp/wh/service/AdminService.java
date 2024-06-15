 package com.jsp.wh.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.wh.requestdto.AdminRequest;

import com.jsp.wh.responsedto.AdminResponse;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

public  interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest, int warehouseId);
	ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@Valid AdminRequest adminRequest); 
	 
	 ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(@Valid AdminRequest adminRequest, 
	   int adminId); 
	 
	 ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminId); 
	 
	 
	 ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins();
 
}
