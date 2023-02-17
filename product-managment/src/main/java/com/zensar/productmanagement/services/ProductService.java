package com.zensar.productmanagement.services;

import java.util.List;

import com.zensar.productmanagement.dto.ProductDTO;
import com.zensar.productmanagement.entity.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProducts(int pageNumber,int pageSize);

	public ProductEntity updateProduct(int productId, ProductEntity product);

	public ProductEntity getProductById(int productId);

	public void deleteProductById(int productId);

	public ProductDTO insertProduct(ProductDTO productDto, String authorization);

}
