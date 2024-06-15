package com.jsp.wh.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wh.requestdto.StorageRequest;
import com.jsp.wh.responsedto.StorageResponse;
import com.jsp.wh.utility.ResponseStructure;
import com.jsp.wh.utility.SimpleStructure;

public interface StorageService { 
	 
	 
	 public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId, int noOfStorageUnits); 
	 
	 public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(int storageId, 
	   StorageRequest storageRequest); 
	 
	}
