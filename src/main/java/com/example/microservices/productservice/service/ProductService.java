package com.example.microservices.productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.microservices.productservice.domain.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.microservices.productservice.model.Product;
import com.example.microservices.productservice.repository.ProductRepository;

@Service
public class ProductService {

	private static List<Product> products = new ArrayList<>();

	static {
		Product product1 = new Product();
		product1.setLabel("Encore Software");
		products.add(product1);
	}
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	public List<Product> getProductsByPage(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);		
		return productRepo.findAll(pageable).getContent();
	}

	public List<Product> filter(FilterRequest filterRequest, Map<String, String> requestParams) {
		return products;
	}
}
