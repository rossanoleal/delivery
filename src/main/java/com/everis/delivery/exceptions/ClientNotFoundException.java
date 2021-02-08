package com.everis.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//se o cliente não possuir cadastro, irá retornar não encontrado.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientNotFoundException() {
	}
	
	public ClientNotFoundException(String message) {
		super(message);
	}
}
