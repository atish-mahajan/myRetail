package com.target.myretailrestapi.service;

import com.target.myretailrestapi.model.Product;

public interface ProductService {
	Product getProductDetails(String id);

	Product addProduct(Product product);

	Product updateProduct(Product product);
}
