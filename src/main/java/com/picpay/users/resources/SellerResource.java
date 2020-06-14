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

import com.picpay.users.DTO.SellerNewDTO;
import com.picpay.users.domain.Seller;
import com.picpay.users.services.SellerService;

@RestController
@RequestMapping(value="/sellers")
public class SellerResource {

	@Autowired
	private SellerService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SellerNewDTO sellerDto){
		
		Seller seller = service.fromDto(sellerDto);
		seller = service.insert(seller);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(seller.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
