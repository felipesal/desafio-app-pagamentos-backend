package com.picpay.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpay.users.DTO.ConsumerNewDTO;
import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.ConsumerRepository;
import com.picpay.users.repositories.UserRepository;

@Service
public class ConsumerService {
	
	@Autowired
	private ConsumerRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	public Consumer fromDto(ConsumerNewDTO consumerDto) {
		User user = userRepository.findByEmail(consumerDto.getEmail());
		
		Consumer consumer = new Consumer(null, user, consumerDto.getUsername());
		
		return consumer;
	}
	
	public Consumer insert(Consumer consumer) {
		
		consumer.setId(null);

		consumer = repo.save(consumer);
		
		return consumer;
	}
	
}
