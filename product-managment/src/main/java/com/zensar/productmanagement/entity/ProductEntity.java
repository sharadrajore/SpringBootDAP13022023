package com.zensar.productmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class ProductEntity {

	@Id
	@Column(name = "id")
	private int productId;
	@Column(name = "name")
	private String productName;
	@Column(name = "cost")
	private int productCost;

}
