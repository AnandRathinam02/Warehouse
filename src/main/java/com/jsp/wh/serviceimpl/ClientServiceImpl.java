package com.jsp.wh.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wh.AdminMapper.ClientMapper;
import com.jsp.wh.entity.Client;
import com.jsp.wh.exception.ClientNotFoundByIdException;
import com.jsp.wh.repository.ClientRepository;
import com.jsp.wh.entity.Client;
import com.jsp.wh.requestdto.ClientRequest;
import com.jsp.wh.responsedto.ClientResponse;
import com.jsp.wh.service.ClientService;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;
@Service 
public class ClientServiceImpl  implements ClientService{ 
 
 @Autowired 
 private ClientMapper clientMapper; 
 @Autowired 
 private ClientRepository clientRepo; 
 @Override 
 public ResponseEntity<ResponseStructure<ClientResponse>> addClient(@Valid ClientRequest clientRequest) { 
   
  String apikey = UUID.randomUUID().toString(); 
   
   Client client = clientMapper.mapToClientRequest(clientRequest, new Client()); 
   client.setApikey(apikey); 
   client = clientRepo.save(client); 
    
   return ResponseEntity.status(HttpStatus.CREATED) 
     .body(new ResponseStructure<ClientResponse>() 
       .setStatuscode(HttpStatus.CREATED.value()) 
       .setMessage("Client data is created") 
       .setData(clientMapper.mapClientResponse(client))); 
 } 
    public ResponseEntity<ResponseStructure<ClientResponse>> updateClient(int clientId, @Valid ClientRequest clientRequest){ 
 
  return clientRepo.findById(clientId).map(existingClient -> { 
   existingClient = clientRepo.save(clientMapper.mapToClientRequest(clientRequest, existingClient)); 
 
 
   return ResponseEntity.status(HttpStatus.OK) 
     .body(new ResponseStructure<ClientResponse>() 
       .setStatuscode(HttpStatus.OK.value()) 
       .setMessage("Client Updated") 
       .setData(clientMapper.mapClientResponse(existingClient))); 
 
  }).orElseThrow(() -> new ClientNotFoundByIdException("client Not found ")); 
 } 
 
 
  
}