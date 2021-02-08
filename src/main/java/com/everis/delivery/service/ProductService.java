package com.everis.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.delivery.entities.ProductEntity;
import com.everis.delivery.exceptions.ProductNotFoundException;
import com.everis.delivery.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> list(){
		return productRepository.findAll();
	}
 
	public ProductEntity create(ProductEntity product) {
		return productRepository.save(product);
	}
	
	// valida a procura de produto cadastrado, se não encontrar, lança uma exceção
	public ProductEntity findById(Long id) throws ProductNotFoundException {
		return productRepository.findById(id).orElseThrow(
				() -> new ProductNotFoundException(String.format("Product #%d not found", id)));
	}
}
