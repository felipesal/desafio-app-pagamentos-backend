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

import com.picpay.users.DTO.SellerDTO;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<SellerDTO>> listar(
			@RequestParam(value = "username", defaultValue = "") String username,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "username") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Seller> list = service.search(username, page, linesPerPage, orderBy, direction);
		
		Page<SellerDTO> listDto = list.map(obj -> new SellerDTO(obj));
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Seller obj = service.findById(id);
		
		return ResponseEntity.ok(obj);
		
	}
}
