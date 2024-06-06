package com.jsp.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wh.entity.Warehouse;

public  interface WarehouseRepo extends JpaRepository<Warehouse,  Integer> {

}
