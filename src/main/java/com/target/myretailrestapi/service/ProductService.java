package com.target.myretailrestapi.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myretailrestapi.exception.ProductNotFoundException;
import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.repository.ProductRepository;

@Service
public class ProductService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

	RedSkyAPI redSkyClient = new RedSkyAPI();

	public ProductService() {
	}

	public Product getProductById(String id) throws IOException, ProductNotFoundException {

		// Maybe if we don't get a response from RedSky API we don't need to call DB.
		// This is just one way to save a call but maybe the business requirement is to
		// still return other product info then the ordering of below calls can be
		// changed
		Product product = productRepository.getProductById(id);
		if (product == null) {
			throw new IOException();
		}
		/*
		 * else { product.name = redSkyClient.getProductNameById(id); }
		 */
		return product;
		//

	}

	public Product updateProduct(Product product) throws IOException {
		Product prd = productRepository.getProductById(product.id);
		if (prd == null) {
			throw new IOException();
		} else {
			return productRepository.save(product);
		}

	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
