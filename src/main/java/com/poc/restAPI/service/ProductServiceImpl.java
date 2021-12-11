package com.poc.restAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.restAPI.dto.ProductDTO;
import com.poc.restAPI.entity.Product;
import com.poc.restAPI.exception.EmptyInputException;
import com.poc.restAPI.exception.GenericException;
import com.poc.restAPI.repository.ProductRepository;

import static com.poc.restAPI.validator.Validator.validateInput;
import com.poc.restAPI.util.Constants;

import static com.poc.restAPI.mapper.EntityToDTOMapper.entityToDTOMapper;
import static com.poc.restAPI.mapper.EntityToDTOMapper.dtoToEntityMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	// Purpose : To get all products object from Database
	@Override
	public List<ProductDTO> getAllProducts() {
		try {
			List<Product> productList = productRepo.findAll();
			List<ProductDTO> productDTOList = productList.stream().map(e -> entityToDTOMapper(e))
					.collect(Collectors.toList());
			return productDTOList;
		} catch (Exception e) {
			throw new GenericException(Constants.TRY_AGAIN, e.getMessage());
		}
	}

	// Purpose : To retrieve Products based on brands
	@Override
	public List<ProductDTO> getProductByBrand(List<String> brands) {
		// TODO Auto-generated method stub
		try {
			validateInput(brands);
			List<Product> productList = productRepo.findProductByBrands(brands);
			List<ProductDTO> productDTOList = productList.stream().map(e -> entityToDTOMapper(e))
					.collect(Collectors.toList());
			return productDTOList;
		} catch (EmptyInputException exception) {
			throw exception;
		} catch (Exception e) {
			throw new GenericException(Constants.TRY_AGAIN, e.getMessage());
		}
	}

	// Purpose : To retrieve Products based on price
	@Override
	public List<ProductDTO> getProductByPrice(List<Long> priceList) {
		try {
			validateInput(priceList);
			List<Product> productList = productRepo.findProductByPrice(priceList);
			List<ProductDTO> productDTOList = productList.stream().map(e -> entityToDTOMapper(e))
					.collect(Collectors.toList());
			return productDTOList;
		} catch (EmptyInputException exception) {
			throw exception;
		} catch (Exception e) {
			throw new GenericException(Constants.TRY_AGAIN, e.getMessage());
		}
	}

	// Purpose : To add new Product
	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		try {
			validateInput(productDTO);
			Product product = dtoToEntityMapper(productDTO);
			Product savedProduct = productRepo.save(product);
			ProductDTO savedProductDTO = entityToDTOMapper(savedProduct);
			return savedProductDTO;
		} catch (EmptyInputException exception) {
			throw exception;
		} catch (Exception e) {
			throw new GenericException(Constants.TRY_AGAIN, e.getMessage());
		}
	}

	// Purpose : To edit existing Product
	@Override
	public ProductDTO editProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		try {
			validateInput(productDTO);
			Product product = dtoToEntityMapper(productDTO);
			Product savedProduct = productRepo.save(product);
			ProductDTO savedProductDTO = entityToDTOMapper(savedProduct);
			return savedProductDTO;
		} catch (EmptyInputException exception) {
			throw exception;
		} catch (Exception e) {
			throw new GenericException(Constants.TRY_AGAIN, e.getMessage());
		}
	}

	// Purpose : To delete Product
	@Override
	public long deleteProductById(long id) {
		// TODO Auto-generated method stub
		try {
			validateInput(id);
			productRepo.deleteById(id);
			return id;
		} catch (EmptyInputException exception) {
			throw exception;
		} catch (Exception e) {
			throw new GenericException(Constants.TRY_AGAIN, e.getMessage());
		}
	}
}
