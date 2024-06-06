package com.jsp.wh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.wh.entity.Admin;
import com.jsp.wh.enums.AdminType;
 

public  interface  AdminRepository extends  JpaRepository<Admin, Integer> {


    boolean existsByAdminType(AdminType adminType);

	 Optional<Admin> findByEmail(String username);

}
