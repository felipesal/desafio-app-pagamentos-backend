package com.picpay.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.users.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	
}
