package com.poc.restAPI.mapper;

import com.poc.restAPI.dto.ProductDTO;
import com.poc.restAPI.entity.Product;

public class EntityToDTOMapper {

	/**
	 * Purpose : Convert Product Entity Object to ProductDTO Object
	 * @param product
	 * @return
	 */
	public static ProductDTO entityToDTOMapper(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setBrand(product.getBrand());
		productDTO.setPrice(product.getPrice());
		productDTO.setSize(product.getSize());
		return productDTO; 
		
	}
	
	/**
	 * Purpose : Convert ProductDTO to Product Entity Object 
	 * @param productDTO
	 * @return
	 */
	public static Product dtoToEntityMapper(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setBrand(productDTO.getBrand());
		product.setPrice(productDTO.getPrice());
		product.setSize(productDTO.getSize());
		return product; 
		
	}
}
