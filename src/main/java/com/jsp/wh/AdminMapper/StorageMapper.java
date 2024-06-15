 package com.jsp.wh.AdminMapper;

import org.springframework.stereotype.Component;

import com.jsp.wh.entity.Storage;
import com.jsp.wh.requestdto.StorageRequest;
import com.jsp.wh.responsedto.StorageResponse;

@Component 
public class StorageMapper { 
   
    
 public Storage mapToStorage(StorageRequest storageRequest, Storage storage) { 
 
  storage.setBlockName(storageRequest.getBlockName()); 
  storage.setSection(storageRequest.getSection()); 
  storage.setLengthInMeters(storageRequest.getLengthInMeters()); 
  storage.setBreadthInMeters(storageRequest.getBreadthInMeters()); 
  storage.setHeightInMeters(storageRequest.getHeightInMeters()); 
  storage.setCapacityInWeight(storageRequest.getCapacityInWeight()); 
  storage.setMaterialTypes(storageRequest.getMaterialTypes()); 
 
  return storage; 
 
 } 
 
 public StorageResponse mapToStorageResponse(Storage storage) { 
  StorageResponse response  = new  StorageResponse();
    response.setStorageId(storage.getStorageId()) ;
    response.setBlockName(storage.getBlockName()) ;
    response.setSection(storage.getSection()) ;
    response.setCapacityInKg(storage.getCapacityInWeight()) ;
    response.setMaterialTypes(storage.getMaterialTypes()) ;
    response.setAvailableArea(storage.getAvailableArea()) ;
    response.setMaxAdditionalWeight(storage.getMaxAdditionalWeight()) ;
    response.setMaterialTypes(storage.getMaterialTypes()) ;
   return response;
 
 
 
 } 
 
 
}