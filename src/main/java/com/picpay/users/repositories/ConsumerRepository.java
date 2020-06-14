package com.picpay.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.users.domain.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	
	Consumer findByUsername(String username);
	
}
