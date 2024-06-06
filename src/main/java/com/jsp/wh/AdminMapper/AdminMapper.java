 package com.jsp.wh.AdminMapper;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Component;

import com.jsp.wh.entity.Admin;
import com.jsp.wh.enums.AdminType;
import com.jsp.wh.requestdto.AdminRequest;
import com.jsp.wh.responsedto.AdminResponse;
@Component
public class AdminMapper {

	public  Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
		 admin.setName(adminRequest.getName());
		 admin.setEmail(adminRequest.getEmail());
		 admin.setPassword(adminRequest.getPassword());
		return  admin;
	}

	 
	public  AdminResponse mapToAdminResponse(Admin admin) {
		 
		 AdminResponse adminResponse = new AdminResponse() ;
		 adminResponse.setAdminId(admin.getAdminId());
		 adminResponse.setName(admin.getName());
		 adminResponse.setEmail(admin.getEmail());
		 adminResponse.setAdminType(admin.getAdminType()); 
		 return adminResponse;
	}

}
