package com.picpay.users.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando";
	}
	
}
