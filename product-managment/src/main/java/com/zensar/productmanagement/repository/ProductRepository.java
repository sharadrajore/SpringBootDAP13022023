package com.zensar.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.productmanagement.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
