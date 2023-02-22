package com.zensar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	private int addressId;

	private String state;

	private String city;

	private int pinCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;

	
	

}
