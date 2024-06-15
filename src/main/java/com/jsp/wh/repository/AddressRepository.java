package com.jsp.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wh.entity.Address;

public  interface AddressRepository  extends JpaRepository<Address,  Integer>{
 
}
