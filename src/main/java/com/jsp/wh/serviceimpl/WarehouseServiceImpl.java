package com.jsp.wh.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.wh.repository.WarehouseRepo;
import com.jsp.wh.service.WarehouseService;

public  class WarehouseServiceImpl implements WarehouseService  {
	@Autowired
	private WarehouseRepo warehouseRepo;
}
