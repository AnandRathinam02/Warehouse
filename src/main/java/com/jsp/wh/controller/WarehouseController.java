package com.jsp.wh.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wh.requestdto.WarehouseRequest;
import com.jsp.wh.responsedto.WarehouseResponse;
import com.jsp.wh.service.WarehouseService;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/api/v1")
public class WarehouseController {
	
	@Autowired
	private WarehouseService  warehouseservice;
	
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PostMapping( "/warehouses")
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createwarehouse ( @RequestBody WarehouseRequest  request){
		return warehouseservice.createwarehouse( request);
	}
	@PreAuthorize("hasAuthority('UPDATE_WAREHOUSE')") 
	 @PutMapping("/warehouses/{warehouseId}") 
	 public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(@RequestBody @Valid 
	   WarehouseRequest wareHouseRequest,@PathVariable int warehouseId){ 
	  return warehouseservice.updateWarehouse(wareHouseRequest,warehouseId); 
	 } 
	 
	 @GetMapping("/warehouses/{warehouseId}") 
	 public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(@PathVariable int warehouseId){ 
	  return warehouseservice.findWarehouse(warehouseId); 
	 }


}
