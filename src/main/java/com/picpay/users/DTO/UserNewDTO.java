package com.picpay.users.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;

import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.Seller;
import com.picpay.users.services.validation.UserInsert;

@UserInsert
public class UserNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	private String cpf;
	private String telefone;
	
	@Email(message = "Email inválido")
	private String email;
	private String senha;
	
	
	private Consumer consumer;
	
	private Seller seller;

	public UserNewDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	

	
	
	
}
