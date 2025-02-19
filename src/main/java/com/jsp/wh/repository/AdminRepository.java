package com.jsp.wh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wh.entity.Admin;
import com.jsp.wh.enums.AdminType;
 

public  interface  AdminRepository extends  JpaRepository<Admin, Integer> {


    boolean existsByAdminType(AdminType adminType);

}
