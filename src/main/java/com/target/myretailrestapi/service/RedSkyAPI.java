package com.target.myretailrestapi.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.repository.ProductRepository;

public class RedSkyAPI {
protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	private ProductRepository productRepository;
	
	public RedSkyAPI() {
	}
	
	public String getProductNameById(String id) throws IOException {
		/*RestTemplate restTemplate = new RestTemplate();
		
		ObjectMapper mapper = new ObjectMapper();
		final String redSkyBaseURL = "https://redsky.target.com/v2/pdp/tcin/%s";
		final String redSkyParams = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
		final String redSkyURL = redSkyBaseURL + redSkyParams;
		String productName = null;
		
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(redSkyURL, String.class, id);
			Map<String, Map> parsedRes = mapper.readValue(response.getBody(), Map.class);
			Map<String, String> resObject = parsedRes.get("product");
			productName = resObject.get("name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return productName from DB for now;*/
		
		Product product = new Product();
		try {
			product = productRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product.name;
		
	}
}
