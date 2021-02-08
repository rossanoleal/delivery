package com.everis.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.entities.ClientEntity;
import com.everis.delivery.repository.ClientRepository;
import com.everis.delivery.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<ClientEntity> list() {
		return clientService.list();
	}
	
	@PostMapping
	public ClientEntity create(@RequestBody ClientEntity client) {
		return clientService.create(client);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ClientEntity> deleteClient(@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping
	public ResponseEntity<ClientEntity> updateClient(@RequestBody ClientEntity client){
		return clientService.update(client);
	}
}