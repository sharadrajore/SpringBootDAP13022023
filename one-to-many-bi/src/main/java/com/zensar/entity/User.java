package com.zensar.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "user" ,cascade =  CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinTable(name = "addressOfUser", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name="addressId"))
	private List<Address> addresses;  

}
