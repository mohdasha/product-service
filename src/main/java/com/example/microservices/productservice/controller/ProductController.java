package com.example.microservices.productservice.controller;

import java.util.List;

import com.example.microservices.productservice.domain.FilterRequest;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.microservices.productservice.model.Product;
import com.example.microservices.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
@SwaggerDefinition(info = @Info(title = "Product Controller", version = "1.0"))
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> get(@RequestParam(defaultValue = "0", name = "page") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		return productService.getProductsByPage(pageNumber, pageSize);
	}

	@PostMapping(value = "/filter")
	public ResponseEntity<List<Product>> filter(@RequestBody FilterRequest filterRequest) {
		System.out.println(filterRequest);
		return null;
	}
}
