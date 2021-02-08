package com.everis.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.dto.OrderDto;
import com.everis.delivery.entities.OrderEntity;
import com.everis.delivery.exceptions.ClientNotFoundException;
import com.everis.delivery.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<OrderEntity> list(){
		return orderService.list();
	}
	
	@PostMapping
	public OrderEntity create(@RequestBody OrderDto dto) throws ClientNotFoundException {
		return orderService.create(dto);
	}
}
