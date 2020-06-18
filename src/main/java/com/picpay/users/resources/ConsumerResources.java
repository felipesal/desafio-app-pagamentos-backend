package com.picpay.users.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.picpay.users.DTO.ConsumerDTO;
import com.picpay.users.DTO.ConsumerNewDTO;
import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.User;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ConsumerDTO>> listar(
			@RequestParam(value = "username", defaultValue = "") String username,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "username") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Consumer> list = service.search(username, page, linesPerPage, orderBy, direction);
		
		Page<ConsumerDTO> listDto = list.map(obj -> new ConsumerDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Consumer obj = service.findById(id);
		
		return ResponseEntity.ok(obj);
		
	}
	
	
}
