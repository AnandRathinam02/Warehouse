package com.jsp.wh.serviceimpl;

import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.wh.AdminMapper.AdminMapper;
import com.jsp.wh.entity.Admin;
import com.jsp.wh.entity.Warehouse;
import com.jsp.wh.enums.AdminType;
import com.jsp.wh.enums.Privilege;
import com.jsp.wh.exception.AdminNotFoundByEmailException;
import com.jsp.wh.exception.SuperAdminAlreadyExistException;
import com.jsp.wh.exception.WarehouseNotFoundException;
import com.jsp.wh.repository.AdminRepository;
import com.jsp.wh.repository.WarehouseRepo;
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
	@Autowired
	private WarehouseRepo warehouseRepo;



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
						.setData(mapper.mapToAdminResponse(admin)));


	}



	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest, int warehouseId) {
// Optional<Warehouse> optional = warehouseRepo.findById(warehouseId);
//		if (  optional.isEmpty())
//			throw  new WarehouseNotFoundException( " Warehouse not  present");
//
//		Admin   admin = mapper.mapToAdmin(adminRequest, new Admin());
//		admin.setAdminType(AdminType.ADMIN);
//		admin=adminRepository.save(admin);
//		Warehouse warehouse = optional.get();
//		warehouse.setAdmin(admin);
//		
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body( new ResponseStructure<AdminResponse>()
//						.setStatuscode(HttpStatus.CREATED.value())
//						.setMessage("Admin added")
//						.setData(mapper.mapToAdminResponse(admin))

//				)  ;
	return 	warehouseRepo.findById(warehouseId).map(warehouse->{
			Admin   admin = mapper.mapToAdmin(adminRequest, new Admin());
			admin.setAdminType(AdminType.ADMIN);
			admin=adminRepository.save(admin);
			warehouse.setAdmin(admin);
			warehouseRepo.save(warehouse);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body( new ResponseStructure<AdminResponse>()
							.setStatuscode(HttpStatus.CREATED.value())
							.setMessage("Admin added")
							.setData(mapper.mapToAdminResponse(admin)));

			
		}).orElseThrow( ()-> new WarehouseNotFoundException("Warehouse not found "));
	 


	}

 
	 @Override 
	 public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(AdminRequest adminRequest) { 
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		   String email = auth.getName(); 
	    
	  return adminRepository.findByEmail(email).map(exAdmin -> 
	   { 
//	    exAdmin.setName(adminRequest.getName()); 
//	    exAdmin.setEmail(adminRequest.getEmail()); 
//	    exAdmin.setPassword(adminRequest.getPassword()); 
	     
	    Admin admin = mapper.mapToAdmin(adminRequest, exAdmin); 
	     
	     adminRepository.save(admin); 
	     
	   return ResponseEntity.status(HttpStatus.OK) 
	      .body(new ResponseStructure<AdminResponse>() 
	      .setStatuscode(HttpStatus.OK.value()) 
	      .setMessage("Admin Updated") 
	      .setData(mapper.mapToAdminResponse(admin))); 
	   }).orElseThrow(()-> new AdminNotFoundByEmailException("Admin not found")); 
	   
	 } 
	 
	 @Override 
	 public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(  AdminRequest adminRequest, int adminId) { 
	  return adminRepository.findById(adminId).map(exAdmin -> 
	   { 
	    Admin admin = mapper.mapToAdmin(adminRequest, exAdmin); 
	     
	     adminRepository.save(admin); 
	     
	   return ResponseEntity.status(HttpStatus.OK) 
	      .body(new ResponseStructure<AdminResponse>() 
	      .setStatuscode(HttpStatus.OK.value()) 
	      .setMessage("Admin Updated") 
	      .setData(mapper.mapToAdminResponse(admin))); 
	   }).orElseThrow(()-> new AdminNotFoundByEmailException("Admin not found")); 
	   
	 } 
	 
	 @Override 
	 public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminId) { 
	  return adminRepository.findById(adminId).map(admin -> ResponseEntity 
	    .status(HttpStatus.FOUND) 
	    .body(new ResponseStructure<AdminResponse>() 
	      .setStatuscode(HttpStatus.FOUND.value()) 
	      .setMessage("Admin found") 
	      .setData(mapper.mapToAdminResponse(admin))) 
	    ).orElseThrow(() ->new AdminNotFoundByEmailException("Admin not found")); 
	 } 
	 
	 @Override 
	 public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins() { 
	  List<AdminResponse> adminsList = adminRepository.findAll().stream().map(admin ->  
	  mapper.mapToAdminResponse(admin)).toList(); 
	  
	 return ResponseEntity.status(HttpStatus.FOUND) 
	   .body(new ResponseStructure<List<AdminResponse>>() 
	     .setStatuscode(HttpStatus.FOUND.value()) 
	     .setMessage("Admins Found") 
	     .setData(adminsList)); 
	 }



}
