package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.delivery.entities.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,  Long> {

}
