package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.delivery.entities.OrderEntity;

@Repository
public interface OrderRepository  extends JpaRepository<OrderEntity, Long> {

}
