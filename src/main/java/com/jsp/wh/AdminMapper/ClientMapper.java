package com.jsp.wh.AdminMapper;

import org.springframework.stereotype.Component;

import com.jsp.wh.entity.Client;
import com.jsp.wh.requestdto.ClientRequest;
import com.jsp.wh.responsedto.ApiKeyResponse;
import com.jsp.wh.responsedto.ClientResponse;
 
@Component 
public class ClientMapper { 
  
 
 public Client mapToClientRequest( ClientRequest clientRequest, Client client) { 
	 
  client.setBusinessName(clientRequest.getBusinessName()); 
  client.setEmail(clientRequest.getEmail()); 
  client.setContactNumber(clientRequest.getContactNumber()); 
 
  return client; 
 } 
 
 public ApiKeyResponse mapToApiKeyResponse(Client client) { 
	 ApiKeyResponse apiKeyResponse = new ApiKeyResponse();
    apiKeyResponse.setApiKey(client.getApikey()); 
   apiKeyResponse.setMessage("created") ;
   return apiKeyResponse;
   
 
 } 
 
 public ClientResponse mapClientResponse(Client client) { 
   ClientResponse  clientResponse = new ClientResponse();
   clientResponse .setClientId(client.getClientId()) ;
   clientResponse .setBusinessName(client.getBusinessName()) ;
   clientResponse .setEmail(client.getEmail()); 
   clientResponse.setContactNumber(client.getContactNumber()) ;
   return clientResponse;
   
 } 
 }