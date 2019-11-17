package com.example.microservices.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.productservice.model.Product;
import com.example.microservices.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> sayHello(@RequestParam(defaultValue = "0", name = "page") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		return productService.getProductsByPage(pageNumber, pageSize);
	}
}
