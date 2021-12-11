package com.poc.restAPI.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.poc.restAPI.dto.ProductDTO;
import com.poc.restAPI.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProductControllerTest {

	@Mock
	ProductServiceImpl productService;

	@InjectMocks
	ProductController productController;

	@Test
	public void testGetProducts() {
		List<ProductDTO> productDTOList = new ArrayList<>();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand("Peter England");
		productDTO.setId(1);
		productDTO.setPrice(3000);
		productDTO.setSize("M");
		productDTOList.add(productDTO);
		ResponseEntity<List<ProductDTO>> expectedProductDTO = new ResponseEntity<List<ProductDTO>>(productDTOList,
				HttpStatus.OK);
		when(productService.getAllProducts()).thenReturn(productDTOList);
		ResponseEntity<List<ProductDTO>> actualProductDTO = productController.getProducts();
		assertEquals(expectedProductDTO, actualProductDTO);
		assertNotNull(actualProductDTO);
	}
	
	@Test
	public void testGetProductsByBrand() {
		List<ProductDTO> productDTOList = new ArrayList<>();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand("Nike");
		productDTO.setId(2);
		productDTO.setPrice(6000);
		productDTO.setSize("M");
		ProductDTO productDTOSec = new ProductDTO();
		productDTOSec.setBrand("GUCCI");
		productDTOSec.setId(2);
		productDTOSec.setPrice(10000);
		productDTOSec.setSize("M");
		productDTOList.add(productDTO);
		productDTOList.add(productDTOSec);
		
		ResponseEntity<List<ProductDTO>> expectedProductDTO = new ResponseEntity<List<ProductDTO>>(productDTOList,
				HttpStatus.OK);
		when(productService.getProductByBrand(anyList())).thenReturn(productDTOList);
		ResponseEntity<List<ProductDTO>> actualProductDTO = productController.getProductsByBrands(anyList());
		assertEquals(expectedProductDTO, actualProductDTO);
		assertNotNull(actualProductDTO);
	}
	
	@Test
	public void testGetProductsByPrice() {
		List<ProductDTO> productDTOList = new ArrayList<>();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand("Nike");
		productDTO.setId(2);
		productDTO.setPrice(10000);
		productDTO.setSize("M");
		ProductDTO productDTOSec = new ProductDTO();
		productDTOSec.setBrand("GUCCI");
		productDTOSec.setId(2);
		productDTOSec.setPrice(10000);
		productDTOSec.setSize("M");
		productDTOList.add(productDTO);
		productDTOList.add(productDTOSec);
		
		ResponseEntity<List<ProductDTO>> expectedProductDTO = new ResponseEntity<List<ProductDTO>>(productDTOList,
				HttpStatus.OK);
		when(productService.getProductByPrice(anyList())).thenReturn(productDTOList);
		ResponseEntity<List<ProductDTO>> actualProductDTO = productController.getProductsByPrice(anyList());
		assertEquals(expectedProductDTO, actualProductDTO);
		assertNotNull(actualProductDTO);
	}
	
	@Test
	public void testAddProduct() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand("Arrow");
		productDTO.setId(1);
		productDTO.setPrice(1900);
		productDTO.setSize("M");
		
		ResponseEntity<ProductDTO> expectedProductDTO = new ResponseEntity<ProductDTO>(productDTO,
				HttpStatus.OK);
		when(productService.addProduct(productDTO)).thenReturn(productDTO);
		ResponseEntity<ProductDTO> actualProductDTO = productController.addProduct(productDTO);
		assertEquals(expectedProductDTO, actualProductDTO);
		assertNotNull(actualProductDTO);
	}
	public void testEditProduct() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand("Arrow");
		productDTO.setId(1);
		productDTO.setPrice(1800);
		productDTO.setSize("XL");
		
		ResponseEntity<ProductDTO> expectedProductDTO = new ResponseEntity<ProductDTO>(productDTO,
				HttpStatus.OK);
		when(productService.editProduct(productDTO)).thenReturn(productDTO);
		ResponseEntity<ProductDTO> actualProductDTO = productController.editProduct(productDTO);
		assertEquals(expectedProductDTO, actualProductDTO);
		assertNotNull(actualProductDTO);
	}
	
	public void testDeleteProduct() {
		long id = 2; 
		ResponseEntity<Long> expectedID = new ResponseEntity<Long>(id,
				HttpStatus.OK);
		when(productService.deleteProductById(anyLong())).thenReturn(id);
		ResponseEntity<Long> actualID = productController.deleteProduct(id);
		assertEquals(expectedID, actualID);
		assertNotNull(actualID);
	}
}
