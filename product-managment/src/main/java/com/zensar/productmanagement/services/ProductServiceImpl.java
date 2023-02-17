package com.zensar.productmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.productmanagement.entity.Product;
import com.zensar.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void insertProduct(Product product, String authorization) {
		if (authorization.equals("sr43993"))
			productRepository.save(product);
	}

	public void deleteProductById(int productId) {
		productRepository.deleteById(productId);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();   
	}

	public Product updateProduct(int productId, Product product) {
		Optional<Product> availableProduct = productRepository.findById(productId);
		Product product2 = availableProduct.get();
			if(product2!=null) {
				return productRepository.save(product2);
			}
		//product2.setProductName(product.getProductName());
		//product2.setProductCost(product.getProductCost());
		//product2.setProductId(product.getProductId());
		return null;
	}

	public Product getProductById(int productId) {
		return productRepository.findById(productId).get();
	}

}
