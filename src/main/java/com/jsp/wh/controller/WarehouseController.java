package com.jsp.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wh.requestdto.WarehouseRequest;
import com.jsp.wh.responsedto.WarehouseResponse;
import com.jsp.wh.service.WarehouseService;
import com.jsp.wh.utility.ResponseStructure;

 
@RestController
public class WarehouseController {
    @Autowired
	private WarehouseService service;
 	
}
