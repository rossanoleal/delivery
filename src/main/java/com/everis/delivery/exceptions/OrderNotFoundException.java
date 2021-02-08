package com.everis.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//se o pedido não possuir cadastro, irá retornar não encontrado.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() {
	}
	
	public OrderNotFoundException(String message) {
		super(message);
	}
}