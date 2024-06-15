package com.jsp.wh.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wh.requestdto.AddressRequest;
import com.jsp.wh.responsedto.AddressResponse;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

public  interface  AddressService {

	ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid AddressRequest addressRequest, int warehouseId);

	ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@Valid AddressRequest addressRequest,
			int addressId);

	ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId);

 
}
