package com.everis.delivery.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.delivery.dto.OrderDto;
import com.everis.delivery.entities.ClientEntity;
import com.everis.delivery.entities.ItemEntity;
import com.everis.delivery.entities.OrderEntity;
import com.everis.delivery.entities.ProductEntity;
import com.everis.delivery.enums.OrderStatus;
import com.everis.delivery.exceptions.ClientNotFoundException;
import com.everis.delivery.exceptions.OrderNotFoundException;
import com.everis.delivery.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ProductService productService;

	public List<OrderEntity> list() {
		return orderRepository.findAll();
	}

	public OrderEntity create(OrderDto dto) throws ClientNotFoundException {
		ClientEntity client = clientService.findById(dto.getClientId());
		
		OrderEntity orders = new OrderEntity(client, LocalDateTime.now(), OrderStatus.PENDING);
		
		List<ItemEntity> items = dto.getProducts().stream()
				.map(item -> {
					try {
						ProductEntity product = productService.findById(item.getProductId());
						return new ItemEntity(orders, product.getDescription(), product.getPrice(), item.getQuantity());
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).collect((Collectors.toList()));
		// TODO: verificação de quantidade de produtos de acordo com a regra de negócio
		double total = items.stream().filter(item -> item.getQuantity() > 0).mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
		orders.setTotal(total);
		orders.setItems(items);
		
		return orderRepository.save(orders);
	}
	
	// valida a procura de pedidos cadastrados, se não encontrar, lança uma exceção
	public OrderEntity findById(Long id) throws OrderNotFoundException {
		return orderRepository.findById(id).orElseThrow(
				() -> new OrderNotFoundException("Order not found"));
	}

}
