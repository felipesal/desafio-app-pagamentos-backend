package com.picpay.users.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.picpay.users.interfaces.TipoUser;

@Entity
public class Consumer implements Serializable, TipoUser{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	@OneToOne
	@JoinColumn(name = "User_id")
	@MapsId
	private User userId;
	private String username;
	
	public Consumer() {
		
	}

	public Consumer(Integer id, User userId, String username) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
	
	
	

}
