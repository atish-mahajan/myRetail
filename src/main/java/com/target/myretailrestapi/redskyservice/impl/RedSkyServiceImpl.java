package com.target.myretailrestapi.redskyservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedSkyServiceImpl {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getProductNameById(String id) {
		RestTemplate restTemplate = new RestTemplate();

		ObjectMapper mapper = new ObjectMapper();
		final String redSkyBaseURL = "https://redsky.target.com/v3/pdp/tcin/{id}";
		final String redSkyParams = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";
		final String redSkyURL = redSkyBaseURL + redSkyParams;
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		String productName = null;

		try {
			ResponseEntity<String> response = restTemplate.getForEntity(redSkyURL, String.class, param);
			Map<String, Map> parsedRes = mapper.readValue(response.getBody(), Map.class);
			Map<String, Map> resObject = parsedRes.get("product");
			Map<String, Map> resItem = resObject.get("item");
			Map<String, String> resDesc = resItem.get("product_description");
			productName = resDesc.get("title");
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return productName;
	}
}
