package com.picpay.users.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.picpay.users.services.validation.SellerInsert;



;


@SellerInsert
public class SellerNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String email;
	private String razao;
	private String fantasia;
	private String cnpj;
	private String username;
	
	public SellerNewDTO() {
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	
}
