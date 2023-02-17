package com.zensar.productmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.productmanagement.entity.Product;
import com.zensar.productmanagement.services.ProductService;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ProductController {

	// CRUD -> Created,Read,Updated,Deleted
	
	private ProductService productService;

	//public ProductController() {

	//}


	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// http://localhost:7000/products -> POST

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertProduct(@RequestBody Product product, @RequestHeader("Authorization") String authorization) {
			System.out.println("Authorization :- " + authorization);
			productService.insertProduct(product, authorization);
	}

	// http://localhost:7000/products/1
	@DeleteMapping("/products/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		 productService.deleteProductById(productId);
	}

	// http://localhost:7000/products -> GET

	// @RequestMapping(value = "/product",method=RequestMethod.GET)
	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// http://localhost:7000/products/1

	@PutMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}

	// http://localhost:7000/products/1 -> GET
	@GetMapping(value = "/products/{productId}")
	public Product getProductById(@PathVariable("productId") int productId) {
		return productService.getProductById(productId);
	}

}
