package com.zensar.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.zensar.productmanagement.controllers.ProductController;
import com.zensar.productmanagement.entity.Product;

@SpringBootApplication
public class ProductManagmentApplication extends SpringBootServletInitializer{
	
	
	

	public static void main(String[] args) {
		 SpringApplication.run(ProductManagmentApplication.class, args); 
		
		//ProductController controller=(ProductController)context.getBean("productController");
		
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}
	
	


	
	

}
