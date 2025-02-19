package com.jsp.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wh.requestdto.AdminRequest;
import com.jsp.wh.responsedto.AdminResponse;
import com.jsp.wh.service.AdminService;
 
import com.jsp.wh.utility.ErrorStructure;
import com.jsp.wh.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
 
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController

public class AdminController {
	
	 @Autowired
	 private AdminService adminService;
	 
	  @Operation( description = " the endpont is used to add the superadmin in the data base" , responses= {
			 @ApiResponse ( responseCode = "201",description = "Admin created") ,
			 @ApiResponse( responseCode =  "400" , description =  "Invalid input ", content = {
					 @Content ( schema = @Schema( oneOf = ErrorStructure.class))
			 })
	  })
	 @PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin( @RequestBody  @Valid AdminRequest adminRequest){
		return adminService.addSuperAdmin(adminRequest);
	}
	  
	  

}
