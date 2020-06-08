package com.picpay.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.users.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
