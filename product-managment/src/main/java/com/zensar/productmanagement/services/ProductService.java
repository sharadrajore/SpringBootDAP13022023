package com.zensar.productmanagement.services;

import java.util.List;

import com.zensar.productmanagement.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product updateProduct(int productId, Product product);

	public Product getProductById(int productId);

	public void deleteProductById(int productId);

	public void insertProduct(Product product, String authorization);

}
