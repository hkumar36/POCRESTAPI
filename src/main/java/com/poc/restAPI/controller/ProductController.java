package com.poc.restAPI.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.restAPI.dto.ProductDTO;
import com.poc.restAPI.service.ProductService;

@RestController

public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getProducts() {
		logger.info("Inside method : getProducts()");
		List<ProductDTO> response = productService.getAllProducts();
		return new ResponseEntity<List<ProductDTO>>(response, HttpStatus.OK);
	}

	@PostMapping("/brand")
	public ResponseEntity<List<ProductDTO>> getProductsByBrands(@RequestBody List<String> brands) {
		logger.info("Inside method : getProductsByBrands()");
		List<ProductDTO> response = productService.getProductByBrand(brands);
		return new ResponseEntity<List<ProductDTO>>(response, HttpStatus.OK);
	}

	@PostMapping("/price")
	public ResponseEntity<List<ProductDTO>> getProductsByPrice(@RequestBody List<Long> priceList) {
		logger.info("Inside method : getProductsByPrice()");
		List<ProductDTO> response = productService.getProductByPrice(priceList);
		return new ResponseEntity<List<ProductDTO>>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
		logger.info("Inside method : addProducts()");
		ProductDTO response = productService.addProduct(productDTO);
		return new ResponseEntity<ProductDTO>(response, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ProductDTO> editProduct(@RequestBody ProductDTO productDTO) {
		logger.info("Inside method : editProduct()");
		ProductDTO response = productService.editProduct(productDTO);
		return new ResponseEntity<ProductDTO>(response, HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<Long> deleteProduct(@RequestParam long id) {
		logger.info("Inside method : deleteProduct()");
		id = productService.deleteProductById(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
}
