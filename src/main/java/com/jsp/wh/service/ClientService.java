package com.jsp.wh.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wh.requestdto.ClientRequest;
import com.jsp.wh.responsedto.ClientResponse;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface ClientService {

	ResponseEntity<ResponseStructure<ClientResponse>> addClient(@Valid ClientRequest clientRequest);

	ResponseEntity<ResponseStructure<ClientResponse>> updateClient(int clientId, ClientRequest clientRequest); 
	 
	 
	}
