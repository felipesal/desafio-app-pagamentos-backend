package com.picpay.users.domain;

import java.io.Serializable;

public class Consumer extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double userId;
	private String username;
	
	public Consumer() {
		
	}

	public Consumer(Double userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public Double getUserId() {
		return userId;
	}

	public void setUserId(Double userId) {
		this.userId = userId;
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
		Consumer other = (Consumer) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
	

}
