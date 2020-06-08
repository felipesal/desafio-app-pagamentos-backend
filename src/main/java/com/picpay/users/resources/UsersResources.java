package com.picpay.users.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.users.domain.User;
import com.picpay.users.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listar() {
		return service.findAll();
	}
	
}
