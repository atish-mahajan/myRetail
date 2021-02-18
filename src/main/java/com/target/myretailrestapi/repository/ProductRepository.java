package com.target.myretailrestapi.repository;

import com.target.myretailrestapi.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	//Product getProductById(String id);
}
