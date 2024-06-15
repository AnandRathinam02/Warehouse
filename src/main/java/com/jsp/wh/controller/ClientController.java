package com.jsp.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wh.requestdto.ClientRequest;
import com.jsp.wh.responsedto.ClientResponse;
import com.jsp.wh.service.ClientService;
import com.jsp.wh.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/v1") 
public class ClientController { 
	@Autowired
	private ClientService clientService; 

	@PostMapping("/clients") 
	public ResponseEntity<ResponseStructure<ClientResponse>> addClient ( @RequestBody  @Valid ClientRequest clientRequest){ 
		return clientService.addClient(clientRequest); 
	} 


	@PutMapping("clients/{clientId}") 
	public ResponseEntity<ResponseStructure<ClientResponse>> updateClient(@PathVariable int clientId,  
			@RequestBody ClientRequest clientRequest) {

		return clientService.updateClient(clientId,clientRequest); 
	} 

}
