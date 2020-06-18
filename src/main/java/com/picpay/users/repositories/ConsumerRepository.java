package com.picpay.users.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.picpay.users.domain.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	
	@Query("SELECT obj FROM Consumer obj WHERE obj.username LIKE %:un%")
	Page<Consumer> findByUsername(@Param("un")String username, Pageable pageRequest);
	
	Consumer findByUsername(String username);
	
}
