package com.picpay.users.DTO;

import com.picpay.users.domain.Seller;

public class SellerDTO {
	
	private Integer id;

	private String name;
	
	private String username;

	public SellerDTO(Seller obj) {
		this.id = obj.getId();
		this.name = obj.getUserId().getNome();
		this.username = obj.getUsername();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
}
