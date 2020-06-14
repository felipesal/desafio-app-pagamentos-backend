package com.picpay.users.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.picpay.users.DTO.ConsumerNewDTO;
import com.picpay.users.domain.Consumer;
import com.picpay.users.services.ConsumerService;

@RestController
@RequestMapping(value = "/consumers")
public class ConsumerResources {
	
	@Autowired
	private ConsumerService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ConsumerNewDTO consumerDto){
		
		Consumer consumer = service.fromDto(consumerDto);
		consumer = service.insert(consumer);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(consumer.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
