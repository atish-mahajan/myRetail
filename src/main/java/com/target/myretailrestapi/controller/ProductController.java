package com.target.myretailrestapi.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.myretailrestapi.exception.InvalidProductIdException;
import com.target.myretailrestapi.exception.ProductMisMatchException;
import com.target.myretailrestapi.exception.ProductNotFoundException;
import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.repository.ProductRepository;
import com.target.myretailrestapi.service.impl.ProductServiceImpl;

@RestController
public class ProductController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductServiceImpl productService;

	@Autowired
	ProductRepository productRepository;

	@GetMapping(value = "/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductDetails(@PathVariable String id) {
		Product product = null;
		if (!validProductId(id)) {
			throw new InvalidProductIdException();
		}
		else
			product = productService.getProductDetails(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		/*try {
			if (!validProductId(id)) {
				throw new InvalidProductIdException();
			}
			else {
				product = productService.getProductDetails(id);
			}
			
		} catch (InvalidProductIdException ex) {
			//logger.debug("Product not found exception " + e);
			
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);*/
	}

	@PostMapping(value = "/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProductPrice(@RequestBody Product product) {
		Product p1 = productService.addProduct(product);
		return p1;
	}

	@PutMapping(value = "/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product)
			throws IOException {
		if (!id.equalsIgnoreCase(product.id)) {
			throw new ProductMisMatchException();
		} else {
			try {
				product = productService.updateProduct(product);
			} catch (Exception e) {
				throw new ProductNotFoundException();
			}
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	boolean validProductId(String id) {
		//this can be expanded with modified Regex and more validation like product number can't start with 0
		
		if (id.matches("[0-9]+"))
			return true;
		else 
			return false;
	}

}
