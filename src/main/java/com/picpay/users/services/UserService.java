package com.picpay.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.users.DTO.UserNewDTO;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.UserRepository;
import com.picpay.users.services.exceptions.ObjectNotFoundException;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User fromDto(UserNewDTO userDto) {
		User user = new User();
		user.setNome(userDto.getNome());
		user.setCpf(userDto.getCpf());
		user.setEmail(userDto.getEmail());
		user.setTelefone(userDto.getTelefone());
		user.setSenha(userDto.getSenha());
		return user;
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException (
				"Objeto não encontrado. Id: " + id + ", Tipo: " + User.class.getName()));
		
	}
	
	
	public Page<User> search(String name, Integer page, Integer linesPerPage, String orderBy, String direction) {
		 
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.search(name, pageRequest);
	}
	
	@Transactional
	public User insert(User user) {
		user.setId(null);
		
		user = repo.save(user);
		
		return user;
	}
	
}
