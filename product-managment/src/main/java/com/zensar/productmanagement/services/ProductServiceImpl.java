package com.zensar.productmanagement.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.productmanagement.dto.ProductDTO;
import com.zensar.productmanagement.entity.ProductEntity;
import com.zensar.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ProductDTO insertProduct(ProductDTO productDto, String authorization) {

		ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);

		// ProductEntity productEntity = mapToEntity(productDto);

		if (authorization.equals("sr43993")) {
			ProductEntity savedProduct = productRepository.save(productEntity);

			return modelMapper.map(savedProduct, ProductDTO.class);
			// return mapToDto(savedProduct);
		}
		return null;
	}

	public void deleteProductById(int productId) {
		productRepository.deleteById(productId);
	}

	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	public ProductEntity updateProduct(int productId, ProductEntity product) {

		Optional<ProductEntity> availableProduct = productRepository.findById(productId);
		ProductEntity product2 = availableProduct.get();
		if (product2 != null) {
			return productRepository.save(product2);
		}
		// product2.setProductName(product.getProductName());
		// product2.setProductCost(product.getProductCost());
		// product2.setProductId(product.getProductId());
		return null;
	}

	public ProductEntity getProductById(int productId) {
		return productRepository.findById(productId).get();
	}

	/*
	 * private ProductEntity mapToEntity(ProductDTO productDto) { ProductEntity
	 * productEntity = new ProductEntity();
	 * productEntity.setProductId(productDto.getProductId());
	 * productEntity.setProductName(productDto.getProductName());
	 * productEntity.setProductCost(productDto.getProductCost()); return
	 * productEntity; }
	 * 
	 * private ProductDTO mapToDto(ProductEntity productEntity) { ProductDTO
	 * productDTO = new ProductDTO();
	 * productDTO.setProductId(productEntity.getProductId());
	 * productDTO.setProductName(productEntity.getProductName());
	 * productDTO.setProductCost(productEntity.getProductCost()); return productDTO;
	 * }
	 */

}
