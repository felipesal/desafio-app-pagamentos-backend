package com.picpay.users.DTO;

import java.io.Serializable;

import com.picpay.users.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;

	public UserDTO() {
		
	}

	public UserDTO(User obj) {
		id = obj.getId();
		nome = obj.getNome();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
}
