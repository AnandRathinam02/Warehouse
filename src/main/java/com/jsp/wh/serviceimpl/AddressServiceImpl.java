package com.jsp.wh.serviceimpl;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.wh.AdminMapper.AddressMapper;
import com.jsp.wh.entity.Address;
import com.jsp.wh.entity.Warehouse;
import com.jsp.wh.exception.AddressNotFoundByIdException;
import com.jsp.wh.exception.WarehouseNotFoundByIdException;
import com.jsp.wh.exception.WarehouseNotFoundException;
import com.jsp.wh.repository.AddressRepository;
import com.jsp.wh.repository.WarehouseRepo;
import com.jsp.wh.requestdto.AddressRequest;
import com.jsp.wh.responsedto.AddressResponse;
import com.jsp.wh.service.AddressService;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private WarehouseRepo repo;
	@Autowired
	private AddressMapper   addressMapper;








	@Override
	public ResponseEntity< ResponseStructure<AddressResponse>> addAddress( AddressRequest addressRequest,
			int warehouseId) {
		return repo.findById(warehouseId).map(  ad ->{
			Address address = addressMapper.maptoAddress(addressRequest,  new Address());
			address.setWarehouse(ad);
			address= addressRepository.save(address);

			//repo.save(ad);
			return ResponseEntity.status(HttpStatus.CREATED).body( 
					new  ResponseStructure<AddressResponse>()
					.setStatuscode( HttpStatus.OK.value())
					.setMessage("Address update ")
					.setData(addressMapper.maptoAddressResponse(address)));



		}).orElseThrow( ()-> new WarehouseNotFoundByIdException("Warehouse is not present "));


	}
	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(  AddressRequest addressRequest,
			int addressId) {
		return  addressRepository.findById(addressId).map(address -> {
			 
			 address = addressMapper.maptoAddress(addressRequest, address);
			 
			 address = addressRepository.save(address);
			 
			 return ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure<AddressResponse>()
					 .setStatuscode(HttpStatus.OK.value())
					 .setMessage("Updated")
					 .setData(addressMapper.maptoAddressResponse(address)));
		 }).orElseThrow(()-> new  AddressNotFoundByIdException("Address not found"));
		
	}
	
 

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId) {

		return addressRepository.findById(addressId).map(address -> {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(new ResponseStructure<AddressResponse>()
							.setStatuscode(HttpStatus.FOUND.value())
							.setMessage("Address Found")
							.setData(addressMapper.maptoAddressResponse(address)));
		}).orElseThrow(()-> new AddressNotFoundByIdException("Address Not Found"));
	}
}
