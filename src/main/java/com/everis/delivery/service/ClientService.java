package com.everis.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.delivery.entities.ClientEntity;
import com.everis.delivery.exceptions.ClientNotFoundException;
import com.everis.delivery.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<ClientEntity> list() {
		return clientRepository.findAll();
	}

	public ClientEntity create(ClientEntity client) {
		return clientRepository.save(client);
	}

	public void delete(Long id) throws ClientNotFoundException {
		clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("client not found"));
		clientRepository.deleteById(id);
	}

	// valida a procura de cliente cadastrado, se não encontrar, lança uma exceção
	public ClientEntity findById(Long id) throws ClientNotFoundException {
		return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("client not found"));
	}

	public ResponseEntity<ClientEntity> update(ClientEntity client) throws ClientNotFoundException {
		ClientEntity clientUpdate = clientRepository.findById(client.getId())
				.orElseThrow(() -> new ClientNotFoundException("client not found"));
		clientRepository.save(client);
		return ResponseEntity.ok(client);
	}
}
