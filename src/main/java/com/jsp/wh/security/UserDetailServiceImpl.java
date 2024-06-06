package com.jsp.wh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsp.wh.entity.Admin;
import com.jsp.wh.repository.AdminRepository;
import com.jsp.wh.serviceimpl.AdminServiceImpl;
@Service
public class UserDetailServiceImpl  implements UserDetailsService{
	@Autowired
   private AdminRepository  adminRepository;
   
	
	@Override
	public UserDetails loadUserByUsername(String username)  {
		 
		return adminRepository.findByEmail(username)
				.map(UserDetailsImpl::new)
				.orElseThrow( ()-> new  UsernameNotFoundException(" User not found "));
		 
	 
	}

}
