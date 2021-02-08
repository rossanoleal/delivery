package com.everis.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//se o produto não possuir cadastro, irá retornar não encontrado.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
