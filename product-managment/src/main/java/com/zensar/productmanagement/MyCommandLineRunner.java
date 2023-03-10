package com.zensar.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import com.zensar.productmanagement.controllers.ProductController;
import com.zensar.productmanagement.dto.ProductDTO;

//@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired 
	private ProductController productController;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside MyCommandLineRunner");
		productController.insertProduct(new ProductDTO(123,"HDD",4500), "sr43993");
		productController.insertProduct(new ProductDTO(456,"Laptop",50500), "sr43993");
		
	} 

}
