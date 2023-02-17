package com.zensar.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import com.zensar.productmanagement.controllers.ProductController;
import com.zensar.productmanagement.dto.ProductDTO;
//@Component
@Order(2)
public class MyApplicationRunner implements ApplicationRunner {
	
	@Autowired
	private ProductController productController;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Inside MyApplicationRunner");
		productController.insertProduct(new ProductDTO(678,"HDD",4500), "sr43993");
		productController.insertProduct(new ProductDTO(789,"Laptop",50500), "sr43993");
		
	}

}
