 package com.jsp.wh.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wh.requestdto.AdminRequest;

import com.jsp.wh.responsedto.AdminResponse;
import com.jsp.wh.utility.ResponseStructure;

public  interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest, int warehouseId);
 
}
