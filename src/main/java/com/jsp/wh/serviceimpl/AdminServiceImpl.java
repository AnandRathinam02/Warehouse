  package com.jsp.wh.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wh.AdminMapper.AdminMapper;
import com.jsp.wh.entity.Admin;
 
import com.jsp.wh.enums.AdminType;
import com.jsp.wh.enums.Privilege;
import com.jsp.wh.exception.SuperAdminAlreadyExistException;
import com.jsp.wh.repository.AdminRepository;
import com.jsp.wh.requestdto.AdminRequest;
import com.jsp.wh.responsedto.AdminResponse;
import com.jsp.wh.service.AdminService;
import com.jsp.wh.utility.ResponseStructure;

@Service
public class AdminServiceImpl  implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminMapper mapper;
	
	 

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin(AdminRequest adminRequest) {
	 
		if (adminRepository.existsByAdminType(AdminType.SUPER_ADMIN)) 
		throw 	new SuperAdminAlreadyExistException( "   Already  the super admin exist");
		 
			 Admin  admin =  mapper.mapToAdmin(adminRequest , new Admin());
			 admin.setAdminType(AdminType.SUPER_ADMIN);
			 admin= adminRepository.save(admin);
			 
		  return ResponseEntity.status(HttpStatus.CREATED)
				 .body(new ResponseStructure<AdminResponse>()
						 .setStatuscode(HttpStatus.CREATED.value())
						 .setMessage(  "User Created")
						 .setData(mapper.mapToAdminResponse(admin))
						 );
		
				 
	}



	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest) {
		return null;
	}
	
	


}
