package com.zensar.productmanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product API",version = "1.0", description = "This is a product api"))
public class ProductManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagmentApplication.class, args);

		// ProductController
		// controller=(ProductController)context.getBean("productController");

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
