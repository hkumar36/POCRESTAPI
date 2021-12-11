package com.poc.restAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.restAPI.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p from Product AS p WHERE p.brand IN (?1)")
	List<Product> findProductByBrands(List<String> brands);
	
	
	@Query("SELECT p from Product AS p WHERE p.price IN (?1)")
	List<Product> findProductByPrice(List<Long> priceList);
	
}
