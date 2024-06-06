package com.jsp.wh.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.wh.entity.Admin;
import com.jsp.wh.enums.Privilege;

public class UserDetailsImpl  implements UserDetails{


	public UserDetailsImpl(Admin admin) {
		super();
		this.admin = admin;
	}

	private Admin admin;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return  admin.getAdminType()
				.getPrivileges()
				.stream()
				.map(privileg->
		        new  SimpleGrantedAuthority( privileg.name())
				).toList();
	}

	@Override
	public String getPassword() {

		return admin.getPassword();
	}

	@Override
	public String getUsername() {

		return admin.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return  true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return  true ;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true ;
	}

	@Override
	public boolean isEnabled() { 

		return true ;
	}

}
