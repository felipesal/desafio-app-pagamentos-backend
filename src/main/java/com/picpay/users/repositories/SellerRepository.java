package com.picpay.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.users.domain.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	Seller findByUsername(String username);
	
}
