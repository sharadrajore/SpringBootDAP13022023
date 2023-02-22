package com.zensar.productmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
// SQL - T and C   JPQL  -> E,P
//@NamedQueries(value = { @NamedQuery(name = "ProductEntity.myMethod", query = "from ProductEntity p where p.productName=?1 and p.productCost=?2") })// JPQL
//@NamedNativeQueries(value = { @NamedNativeQuery(name = "ProductEntity.myMethod", query = "select * from Product p where p.name=?1 and p.cost=?2",resultClass = ProductEntity.class) })// Native SQL Query
public class ProductEntity {

	@Id
	@Column(name = "id")
	private int productId;
	@Column(name = "name")
	private String productName;
	@Column(name = "cost")
	private int productCost;

}
