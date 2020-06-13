package com.picpay.users.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.users.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT obj FROM User obj WHERE obj.nome LIKE %:nome%")
	Page<User> search(@Param("nome") String name, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	User findByEmail(String email);
	
	@Transactional(readOnly = true)
	User findByCpf(String cpf);
}
