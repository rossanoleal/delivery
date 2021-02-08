package com.everis.delivery.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.delivery.entities.OrderEntity;
import com.everis.delivery.entities.PaymentEntity;
import com.everis.delivery.enums.OrderStatus;
import com.everis.delivery.exceptions.OrderNotFoundException;
import com.everis.delivery.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderService orderService;
	
	public List<PaymentEntity> list() {
		return paymentRepository.findAll();
	}
	
	public PaymentEntity create(PaymentEntity payment) throws OrderNotFoundException {
		OrderEntity orders = orderService.findById(payment.getOrders().getId());
		orders.setStatus(OrderStatus.PAID);
		
		payment.setDate(LocalDateTime.now());
		payment.setOrders(orders);
		
		return paymentRepository.save(payment);
	}
}
