 package com.jsp.wh.AdminMapper;

import org.springframework.stereotype.Component;

import com.jsp.wh.entity.Address;
import com.jsp.wh.entity.Admin;
import com.jsp.wh.requestdto.AddressRequest;
import com.jsp.wh.requestdto.AdminRequest;
import com.jsp.wh.responsedto.AddressResponse;
@Component
public class AddressMapper {
  
	public Address maptoAddress (AddressRequest addressRequest  , Address address) {
		address.setAddressLine(addressRequest.getAddressLine());
		address.setCity(addressRequest.getCity());
		address.setCountry(addressRequest.getCountry());
		
		address.setState(addressRequest.getState());
		address.setPincode(addressRequest.getPincode());
		address.setLongitude(addressRequest.getLongitude());
		address.setLatitude(addressRequest.getLatitude());
		return address;
	}
	
	public AddressResponse maptoAddressResponse( Address address) {
		AddressResponse addressResponse = new AddressResponse();
		addressResponse.setAddreessId(address.getAddreessId());
		addressResponse.setAddressLine(address.getAddressLine());
		addressResponse.setState(address.getState());
		
		addressResponse.setCity(address.getCity());
		addressResponse.setPincode(address.getPincode());
		addressResponse.setCountry(address.getCountry());
		addressResponse.setLatitude(address.getLatitude());
		addressResponse.setLogitude(address.getLongitude());
		return addressResponse;
		
	}
	
}
