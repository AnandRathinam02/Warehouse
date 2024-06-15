package com.jsp.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wh.requestdto.AddressRequest;
import com.jsp.wh.responsedto.AddressResponse;
import com.jsp.wh.service.AddressService;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AddreesController {
	
	@Autowired
	private AddressService addressService;
	@PreAuthorize( "hasAuthority('CREATE_ADDRESS')")
	@PostMapping("/warehouses/{warehouseId}/addresses")
	public ResponseEntity<ResponseStructure<AddressResponse>> addAddress( @RequestBody @Valid AddressRequest addressRequest , @PathVariable int  warehouseId){
		return addressService.addAddress(addressRequest , warehouseId);
	}



}
