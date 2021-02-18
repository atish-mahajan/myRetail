package com.target.myretailrestapi.service;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Product getProductById(String id) throws IOException {
		
		//Maybe if we don't get a response from RedSky API we don't need to call DB.
		//This is just one way to save a call but maybe the business requirement is to 
		//still return other product info then the ordering of below calls can be changed 
		Product product = new Product();
		//product.name = redSkyClient.getProductNameById(id);
		try {
				product = productRepository.findById(id).orElse(null);
			} catch (Exception e) {
				e.printStackTrace();
				}
			
		return product;
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
