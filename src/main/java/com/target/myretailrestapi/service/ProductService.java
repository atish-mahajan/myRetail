package com.target.myretailrestapi.service;

import com.target.myretailrestapi.model.Product;

public interface ProductService {
	Product getProductDetails(String id);
	Product addProduct(Product product);
	Product updateProduct(Product product);
}

/*
 * @Service public class ProductService { protected Logger logger =
 * LoggerFactory.getLogger(this.getClass());
 * 
 * @Autowired private ProductRepository productRepository;
 * 
 * RedSkyAPI redSkyClient = new RedSkyAPI();
 * 
 * public ProductService() { }
 * 
 * public Product getProductById(String id) throws ProductNotFoundException {
 * 
 * // Maybe if we don't get a response from RedSky API we don't need to call DB.
 * // This is just one way to save a call but maybe the business requirement is
 * to // still return other product info then the ordering of below calls can be
 * // changed Product product = productRepository.getProductById(id); if
 * (product == null) { throw new ProductNotFoundException(); }
 * 
 * //else { product.name = redSkyClient.getProductNameById(id); }
 * 
 * return product;
 * 
 * 
 * }
 * 
 * public Product updateProduct(Product product) throws IOException { Product
 * prd = productRepository.getProductById(product.id); if (prd == null) { throw
 * new IOException(); } else { return productRepository.save(product); }
 * 
 * }
 * 
 * public Product addProduct(Product product) { return
 * productRepository.save(product); } }
 */
