package com.zensar.productmanagement.services;

import java.util.List;
import java.util.Optional;

import com.zensar.productmanagement.dto.ProductDTO;
import com.zensar.productmanagement.entity.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProducts(int pageNumber, int pageSize);

	public ProductEntity updateProduct(int productId, ProductEntity product);

	public Optional<ProductEntity> getProductById(int productId);

	public void deleteProductById(int productId);

	public ProductDTO insertProduct(ProductDTO productDto, String authorization);

	public List<ProductEntity> getProductByItsNameAndCost(String productName, int productCost);

}
