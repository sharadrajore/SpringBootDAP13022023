package com.zensar.entity;

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
public class User {
	@Id
	//@Column(name = "id")
	private int userId;

	//@Column(name = "name")
	private String userName;

	//@Column(name = "age")
	private int userAge;
	
	@OneToOne(mappedBy = "user")
	//@JoinColumn(name="addressId")
	private Address address;

}
