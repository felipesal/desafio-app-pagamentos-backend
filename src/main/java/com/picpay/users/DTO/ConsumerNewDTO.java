package com.picpay.users.DTO;

import java.io.Serializable;
import com.picpay.users.services.validation.ConsumerInsert;

@ConsumerInsert
public class ConsumerNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String email;
	private String username;
	
	public ConsumerNewDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
