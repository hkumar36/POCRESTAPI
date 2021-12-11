package com.poc.restAPI.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.poc.restAPI.dto.ProductDTO;
import com.poc.restAPI.entity.Product;
import com.poc.restAPI.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProductServiceImplTest {
	@Mock
	ProductRepository productRepo;
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testGetAllProducts() {
		List<Product> productList = mockProductList();
		when(productRepo.findAll()).thenReturn(productList);
		List<ProductDTO> actualProductDTOList = productServiceImpl.getAllProducts();
		assertNotNull(actualProductDTOList);
	}


	
	@Test
	public void testGetProductByBrand() {
		List<Product> productList = mockProductList();
		when(productRepo.findProductByBrands(anyList())).thenReturn(productList);
		List<ProductDTO> actualProductDTOList = productServiceImpl.getProductByBrand(Arrays.asList("Arrow"));
		assertNotNull(actualProductDTOList);
	}
	
	@Test
	public void testGetProductByPrice() {
		List<Product> productList = mockProductList();
		when(productRepo.findProductByPrice(anyList())).thenReturn(productList);
		List<ProductDTO> actualProductDTOList = productServiceImpl.getProductByPrice(Arrays.asList(3000l));
		assertNotNull(actualProductDTOList);
	}
	
	@Test
	public void testAddProduct() {
		Product product = mockProduct();
		ProductDTO productDTO = mockProductDTO();
		when(productRepo.save(any())).thenReturn(product);
		ProductDTO actualProductDTOList = productServiceImpl.addProduct(productDTO);
		assertNotNull(actualProductDTOList);
	}
	
	@Test
	public void testEditProduct() {
		Product product = mockProduct();
		ProductDTO productDTO = mockProductDTO();
		when(productRepo.save(any())).thenReturn(product);
		ProductDTO actualProductDTOList = productServiceImpl.editProduct(productDTO);
		assertNotNull(actualProductDTOList);
	}
	
	
	private List<Product> mockProductList() {
		List<Product> productList = new ArrayList<>();
		Product product = new Product();
		product.setBrand("Arrow");
		product.setId(1l);
		product.setPrice(3000);
		product.setSize("M");
		productList.add(product);
		return productList;
	}
	
	private Product mockProduct() {
		Product product = new Product();
		product.setBrand("Arrow");
		product.setId(1l);
		product.setPrice(3000);
		product.setSize("M");
		return product;
	}
	
	private ProductDTO mockProductDTO() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand("Arrow");
		productDTO.setId(1l);
		productDTO.setPrice(3000);
		productDTO.setSize("M");
		return productDTO;
	}
}
