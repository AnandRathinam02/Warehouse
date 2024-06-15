package com.jsp.wh.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wh.requestdto.WarehouseRequest;
import com.jsp.wh.responsedto.WarehouseResponse;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface WarehouseService {

	ResponseEntity<ResponseStructure<WarehouseResponse>> createwarehouse(WarehouseRequest request);
	ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(@Valid WarehouseRequest warehouseRequest, 
			int warehouseId); 

	ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId);
}
