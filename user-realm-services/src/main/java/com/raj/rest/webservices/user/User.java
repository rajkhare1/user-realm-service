package com.raj.rest.webservices.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7489483294838938408L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, message ="Name should have atleaset 2 characters")
	@Column(nullable = false)
	private String name;
	
	private String  description;
	
	private String  key = String.valueOf(serialVersionUID) ;
	
	
	
	public User() {
		
	}
	



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description + ", key=" + key + "]";
	}
	
	
	
	
	
}
