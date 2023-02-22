package com.zensar.productmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.productmanagement.dto.ProductDTO;
import com.zensar.productmanagement.entity.ProductEntity;
import com.zensar.productmanagement.exception.ProductNotFoundException;
import com.zensar.productmanagement.services.ProductService;

@RestController
//@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
//		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ProductController {

	// CRUD -> Created,Read,Updated,Deleted

	private ProductService productService;

	// public ProductController() {

	// }

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// http://localhost:7000/products -> POST

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO productDto,
			@RequestHeader("Authorization") String authorization) {
		System.out.println("Authorization :- " + authorization);
		return new ResponseEntity<ProductDTO>(productService.insertProduct(productDto, authorization),
				HttpStatus.CREATED);
	}

	// http://localhost:7000/products/1
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable int productId) {
		productService.deleteProductById(productId);
		return new ResponseEntity<String>("Product Deleted Successfullyyy", HttpStatus.OK);
	}

	// http://localhost:7000/products -> GET

	// @RequestMapping(value = "/product",method=RequestMethod.GET)
	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<ProductEntity> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize) {

		return productService.getAllProducts(pageNumber, pageSize);
	}

	// http://localhost:7000/products/1

	@PutMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductEntity updateProduct(@PathVariable int productId, @RequestBody ProductEntity product) {
		return productService.updateProduct(productId, product);
	}

	// http://localhost:7000/products/1 -> GET
	@GetMapping(value = "/products/{productId}")
	public ProductEntity getProductById(@PathVariable("productId") int productId) {

		Optional<ProductEntity> productById = productService.getProductById(productId);

		if (productById != null) {
			return productService.getProductById(productId).get();
		} else
			throw new ProductNotFoundException("Product Not Found");

	}

	// http://localhost:8080/products/IPhone -> GET
	@GetMapping(value = "/products/name/{productName}/cost/{productCost}")
	public List<ProductEntity> getProductByName(@PathVariable("productName") String productName,
			@PathVariable("productCost") int productCost) {
		return productService.getProductByItsNameAndCost(productName, productCost);
	}

}
