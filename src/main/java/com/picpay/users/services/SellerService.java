package com.picpay.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpay.users.DTO.SellerNewDTO;
import com.picpay.users.domain.Seller;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.SellerRepository;
import com.picpay.users.repositories.UserRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	public Seller fromDto(SellerNewDTO sellerDto) {
		User user = userRepository.findByEmail(sellerDto.getEmail());
		
		Seller seller = new Seller(null, user, sellerDto.getRazao(), sellerDto.getFantasia(), sellerDto.getCnpj(), sellerDto.getUsername());
		
		
		return seller;
	}
	
	public Seller insert(Seller seller) {
		
		seller.setId(null);

		seller = repo.save(seller);
		
		return seller;
	}
	
}
