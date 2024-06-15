package com.jsp.wh.AdminMapper;

import org.springframework.stereotype.Component;

import com.jsp.wh.entity.Warehouse;
import com.jsp.wh.requestdto.WarehouseRequest;
import com.jsp.wh.responsedto.WarehouseResponse;
@Component
public class WarehouseMapper {
	public Warehouse mapToWarehouse( WarehouseRequest  request ,Warehouse warehouse) {
		   	warehouse.setName(request.getName());
		   	return warehouse;


	}
	public WarehouseResponse mapToWarehouseResponse ( Warehouse warehouse) {
		WarehouseResponse warehouseResponse  = new WarehouseResponse();
		 warehouseResponse.setName(  warehouse.getName());
		 warehouseResponse.setWarehouseId( warehouse.getWarehouseId()) ;
		 return warehouseResponse ;
		 
	}

}
