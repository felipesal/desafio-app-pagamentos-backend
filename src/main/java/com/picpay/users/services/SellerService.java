package com.picpay.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.picpay.users.DTO.SellerNewDTO;
import com.picpay.users.domain.Seller;
import com.picpay.users.domain.Seller;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.SellerRepository;
import com.picpay.users.repositories.UserRepository;
import com.picpay.users.services.exceptions.ObjectNotFoundException;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	public Seller fromDto(SellerNewDTO SellerDto) {
		User user = userRepository.findByEmail(SellerDto.getEmail());
		
		Seller Seller = new Seller(null, user, SellerDto.getRazao(), SellerDto.getFantasia(), SellerDto.getCnpj(), SellerDto.getUsername());
		
		
		return Seller;
	}
	
	public Seller insert(Seller Seller) {
		
		Seller.setId(null);

		Seller = repo.save(Seller);
		
		return Seller;
	}
	
	public Page<Seller> search(String username, Integer page, Integer linesPerPage, String orderBy, String direction) {
		 
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findByUsername(username, pageRequest);
	}
	
	public List<Seller> findAll(){
		return repo.findAll();
	}
	
	public Seller findById(Integer id) {
		
		Optional<Seller> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException (
				"Objeto não encontrado. Id: " + id + ", Tipo: " + User.class.getName()));
		
	}
	
}
