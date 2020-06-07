package com.picpay.users.domain;

import java.io.Serializable;

public class Seller extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double userId;
	private String razaoSocial;
	private String nomeFantasia;
	private Double CNPJ;
	private String username;
	
	public Seller() {
		
	}

	public Seller(Double userId, String razaoSocial, String nomeFantasia, Double cNPJ, String username) {
		super();
		this.userId = userId;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		CNPJ = cNPJ;
		this.username = username;
	}

	public Double getUserId() {
		return userId;
	}

	public void setUserId(Double userId) {
		this.userId = userId;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Double getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Double cNPJ) {
		CNPJ = cNPJ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
	
	
	
}
