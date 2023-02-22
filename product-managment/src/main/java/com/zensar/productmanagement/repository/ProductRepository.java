package com.zensar.productmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.productmanagement.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	//List<ProductEntity> findByProductNameAndProductCost(String productName,int productCost);
	
	//@Query("from ProductEntity p where p.productName=?1 and p.productCost=?2")
	//@Query(value = "select * from Product p where p.name=?1 and p.cost=?2",nativeQuery = true)
	//@Query(value = "select * from Product p where p.name=:productName and p.cost=:productCost",nativeQuery = true)
	@Query(value = "select * from Product p where p.name=:name and p.cost=:cost",nativeQuery = true)
	List<ProductEntity> myMethod(@Param("name")String productName,@Param("cost")int productCost);

	// List<ProductEntity> getByProductName(String productName);

	// List<ProductEntity> readByProductName(String productName);

	// List<ProductEntity> abc(String productName);-> Invalid

}
