package com.target.myretailrestapi.controller;

import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductDetails(@PathVariable String id) throws IOException {
		Product product = null;
		try {
			product = productService.getProductById(id);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProductPrice(@RequestBody Product product) {
		Product p1 = productService.addProduct(product);
		return p1;
	}
	
	@PutMapping(value = "/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		if (!id.equalsIgnoreCase(product.getProductid(id))) {
			//throw product not found exception
		}
		else {
			try {
				product = productService.updateProduct(product);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return product;
	}
	

}
