package com.picpay.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.picpay.users.DTO.ConsumerNewDTO;
import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.ConsumerRepository;
import com.picpay.users.repositories.UserRepository;
import com.picpay.users.services.exceptions.ObjectNotFoundException;

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
	
	public Page<Consumer> search(String username, Integer page, Integer linesPerPage, String orderBy, String direction) {
		 
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findByUsername(username, pageRequest);
	}
	
	public List<Consumer> findAll(){
		return repo.findAll();
	}
	
	public Consumer findById(Integer id) {
		
		Optional<Consumer> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException (
				"Objeto não encontrado. Id: " + id + ", Tipo: " + User.class.getName()));
		
	}
	
}
