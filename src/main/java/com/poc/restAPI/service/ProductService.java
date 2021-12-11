package com.poc.restAPI.service;

import java.util.List;

import com.poc.restAPI.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getAllProducts();
	public List<ProductDTO> getProductByPrice(List<Long> priceList);
	public ProductDTO addProduct(ProductDTO productDTO);
	public long deleteProductById(long id);
	List<ProductDTO> getProductByBrand(List<String> brands);
	ProductDTO editProduct(ProductDTO productDTO);
}


