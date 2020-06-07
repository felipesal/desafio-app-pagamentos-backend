package com.picpay.users.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.users.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listar() {
		User u1 = new User(1,"Ana", "12312312312", "999999999", "ana@gmail.com", "123abc");
		User u2 = new User(2,"Bruno", "23423423423", "888888888", "bruno@gmail.com", "123abc");
		
		List<User> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		
		return users;
		
		
	}
	
}
