package com.jsp.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wh.requestdto.AdminRequest;
import com.jsp.wh.requestdto.WarehouseRequest;
import com.jsp.wh.responsedto.AdminResponse;
import com.jsp.wh.responsedto.WarehouseResponse;
import com.jsp.wh.service.WarehouseService;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

 
@RestController
public class WarehouseController {
    
    @GetMapping("/warehouse")
   	public  String   warehousecreated(  ){
   		return  "warehouse created";
   	}
 	
}
