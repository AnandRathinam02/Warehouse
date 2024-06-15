package com.jsp.wh.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.wh.AdminMapper.WarehouseMapper;
import com.jsp.wh.entity.Warehouse;
import com.jsp.wh.enums.AdminType;
import com.jsp.wh.exception.IllegalEntryException;
import com.jsp.wh.exception.WarehouseNotFoundByIdException;
import com.jsp.wh.repository.WarehouseRepo;
import com.jsp.wh.requestdto.WarehouseRequest;
import com.jsp.wh.responsedto.WarehouseResponse;
import com.jsp.wh.service.WarehouseService;
import com.jsp.wh.utility.ResponseStructure;
@Service

public  class WarehouseServiceImpl implements WarehouseService  {
	@Autowired
	private WarehouseRepo warehouseRepo;
	@Autowired
	private WarehouseMapper warehouseMapper;
	

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createwarehouse(WarehouseRequest request) {
		
		  Warehouse warehouse= warehouseMapper.mapToWarehouse(request,  new Warehouse());
		     warehouseRepo.save(warehouse);
		     
		     return ResponseEntity.status(HttpStatus.CREATED)
		    		 .body(new ResponseStructure<WarehouseResponse>()
		    				 .setStatuscode(HttpStatus.CREATED.value())
		    				 .setMessage("Warehouse created")
		    				 .setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
		    		
		    
//		  Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
//		  boolean isAuthorities =false;
//		  
//		   authentication.getAuthorities().forEach( );
		   
////		  
////		   if ( isAuthorities) {
//			     Warehouse warehouse= warehouseMapper.mapToWarehouse(request,  new Warehouse());
//			     warehouseRepo.save(warehouse);
//			     
//			     return ResponseEntity.status(HttpStatus.CREATED)
//			    		 .body(new ResponseStructure<WarehouseResponse>()
//			    				 .setStatuscode(HttpStatus.CREATED.value())
//			    				 .setMessage("Warehouse created")
//			    				 .setData(warehouseMapper.mapToWarehouseResponse(warehouse)) );
//	
////	}
//		   else throw new IllegalEntryException( " Only Super admin can able to  ");
		  
}
	
	@Override 
	 public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse( 
	     WarehouseRequest warehouseRequest, int warehouseId) { 
	 
	//   return wr.findById(warehouseId).map(existingWarehouse ->{ 
//	    warehouseMapper.mapToWarehouse(warehouseRequest, existingWarehouse); 
//	    existingWarehouse = wr.save(existingWarehouse); 
//	     
//	    return ResponseEntity.status(HttpStatus.OK) 
//	      .body(new ResponseStructure<WarehouseResponse>() 
//	       .setStatuscode(HttpStatus.OK.value()) 
//	       .setMessage("WareHouse Updated") 
//	       .setData(warehouseMapper.mapToWarehouseResponse(existingWarehouse))); 
	//   }).orElseThrow(()-> new WarehouseNotFoundByIdException("wareHouse Not found")); 
	//    
	//  } 
	   
	  return warehouseRepo.findById(warehouseId) 
	    .<ResponseEntity<ResponseStructure<WarehouseResponse>>>map(exWarehouse -> { 
	 
	   exWarehouse = warehouseMapper.mapToWarehouse(warehouseRequest, exWarehouse); 
	 
	   Warehouse warehouse = warehouseRepo.save(exWarehouse); 
	 
	   return ResponseEntity.status(HttpStatus.OK) 
	     .body(new ResponseStructure<WarehouseResponse>() 
	       .setStatuscode(HttpStatus.OK.value()) 
	       .setMessage("Warehouse Updated") 
	       .setData(warehouseMapper.mapToWarehouseResponse(warehouse))); 
	  }).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse Not Found")); 
	 } 
	 
	 @Override 
	 public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId) { 
	  return warehouseRepo.findById(warehouseId). 
	  <ResponseEntity<ResponseStructure<WarehouseResponse>>>map(warehouse->{ 
	  
	 return ResponseEntity.status(HttpStatus.FOUND) 
	   .body(new ResponseStructure<WarehouseResponse>() 
	     .setStatuscode(HttpStatus.FOUND.value()) 
	     .setMessage("Warehouse Found") 
	     .setData(warehouseMapper.mapToWarehouseResponse(warehouse))); 
	}).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse not found by Id")); 
	}
}