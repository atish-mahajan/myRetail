package com.target.myretailrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myretailrestapi.exception.ProductNotFoundException;
import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.redskyservice.impl.RedSkyServiceImpl;
import com.target.myretailrestapi.repository.ProductRepository;
import com.target.myretailrestapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired 
	ProductRepository productRepository;
	
	@Autowired
	RedSkyServiceImpl redSkyService;
	
	@Override
	public Product getProductDetails(String id) throws ProductNotFoundException {
		Product product = productRepository.getProductById(id);
		if (product == null) {
			throw new ProductNotFoundException();
		}
		else {
			product.name = redSkyService.getProductNameById(id); 
			return product;
		}
		
		
	}
	
	@Override
	public Product updateProduct(Product product) {
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	
	@Override
	public Product addProduct(Product product) {
		Product addedProduct = productRepository.save(product);
		return addedProduct;
	}
}
