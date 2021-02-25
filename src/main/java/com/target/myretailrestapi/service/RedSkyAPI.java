package com.target.myretailrestapi.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RedSkyAPI {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	public RedSkyAPI() {
	}

	public String getProductNameById(String id) throws IOException {

		RestTemplate restTemplate = new RestTemplate();

		ObjectMapper mapper = new ObjectMapper();
		final String redSkyBaseURL = "https://redsky.target.com/v3/pdp/tcin/%s";
		final String redSkyParams = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";
		final String redSkyURL = redSkyBaseURL + redSkyParams;
		String productName = null;

		try {
			ResponseEntity<String> response = restTemplate.getForEntity(redSkyURL, String.class, id);
			Map<String, Map> parsedRes = mapper.readValue(response.getBody(), Map.class);
			Map<String, String> resObject = parsedRes.get("product");
			productName = resObject.get("name");
		} catch (Exception e) {
			e.printStackTrace();
		} // return productName from DB for now;

		return productName;

	}
}
