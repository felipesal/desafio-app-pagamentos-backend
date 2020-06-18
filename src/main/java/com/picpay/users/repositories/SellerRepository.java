package com.picpay.users.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.picpay.users.domain.Seller;
import com.picpay.users.domain.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	Seller findByUsername(String username);
	
	@Query("SELECT obj FROM Seller obj WHERE obj.username LIKE %:un%")
	Page<Seller> findByUsername(@Param("un")String username, Pageable pageRequest);
}
