package com.picpay.users.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.users.DTO.UserDTO;
import com.picpay.users.domain.User;
import com.picpay.users.resources.utils.URL;
import com.picpay.users.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {
	
	@Autowired
	private UserService service;
	
	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> listar() {
		List<User> list= service.findAll();
		List<UserDTO> listDto = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		User obj = service.findById(id);
		
		return ResponseEntity.ok(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<UserDTO>> findPage(
		@RequestParam(value = "nome", defaultValue = "") String nome,
		@RequestParam(value = "page", defaultValue = "0") Integer page,
		@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
		@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
		@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		String nomeDecoded = URL.decodeParam(nome);
		Page<User> list = service.search(nomeDecoded, page, linesPerPage, orderBy, direction);
		Page<UserDTO> listDto = list.map(obj -> new UserDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	
		

	
}
