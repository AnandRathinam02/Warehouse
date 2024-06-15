 package com.jsp.wh.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wh.AdminMapper.StorageMapper;
import com.jsp.wh.entity.Storage;
import com.jsp.wh.entity.Warehouse;
import com.jsp.wh.exception.StorageNotFoundByIdException;
import com.jsp.wh.exception.WarehouseNotFoundByIdException;
import com.jsp.wh.repository.StorageRepository;
import com.jsp.wh.repository.WarehouseRepo;
import com.jsp.wh.requestdto.StorageRequest;
import com.jsp.wh.responsedto.StorageResponse;
import com.jsp.wh.service.StorageService;
import com.jsp.wh.utility.ResponseStructure;
import com.jsp.wh.utility.SimpleStructure;

@Service 
public class StorageServiceImpl  implements StorageService{ 
 
 @Autowired 
 private StorageRepository storageRepo; 
 
 @Autowired 
 private StorageMapper storageMapper; 
 
 @Autowired 
 private WarehouseRepo warehouseRepo; 
 
 @Override 
 public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, 
   int wareHouseId, int noOfStorageUnits) { 
 
  Warehouse wareHouse =  warehouseRepo.findById(wareHouseId).orElseThrow(()-> new WarehouseNotFoundByIdException("")); 
 
   List<Storage> storages = new ArrayList<Storage>(); 
    
   int count = 0; 
 
   while(noOfStorageUnits > 0) { 
    
   Storage storage  = storageMapper.mapToStorage(storageRequest, new Storage()); 
    
   storage.setMaxAdditionalWeight(storageRequest.getCapacityInWeight()); 
   storage.setAvailableArea(storageRequest.getLengthInMeters() * storageRequest.getBreadthInMeters() * storageRequest.getHeightInMeters()); 
    
   wareHouse.setTotalCapacity((storageRequest.getCapacityInWeight() * noOfStorageUnits + wareHouse.getTotalCapacity())); 
   storage.setWareHouse(wareHouse); 
    
   storages.add(storage); 
   count++; 
   noOfStorageUnits --; 
  } 
   
  storageRepo.saveAll(storages); 
  warehouseRepo.save(wareHouse); 
 
   
  return ResponseEntity.status(HttpStatus.CREATED).body(new SimpleStructure<String>() 
    .setStatus(HttpStatus.CREATED.value()) 
    .setMesssage(""+count + " Storages created")); 
 
 } 
 
 @Override 
 public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(int storageId, 
   StorageRequest storageRequest) { 
   
   
  return storageRepo.findById(storageId).map(existingStorage -> { 
    
   existingStorage = storageMapper.mapToStorage(storageRequest, existingStorage); 
   storageRepo.save(existingStorage); 
    
   return ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure<StorageResponse>() 
     .setStatuscode(HttpStatus.OK.value()) 
     .setMessage("Storage updsates") 
     .setData(storageMapper.mapToStorageResponse(existingStorage))); 
      
    
  }).orElseThrow(()-> new StorageNotFoundByIdException("storage Not Found")); 
 } 
 
 
}
