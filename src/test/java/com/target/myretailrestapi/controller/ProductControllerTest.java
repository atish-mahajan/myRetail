package com.target.myretailrestapi.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.target.myretailrestapi.model.CurrentPrice;
import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.service.ProductService;

@WebMvcTest(value = ProductController.class)
@RunWith(SpringRunner.class)
public class ProductControllerTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductService productServiceMock;

	@MockBean
	ProductController productControllerMocked;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getProductDetailsTest() throws Exception {
		CurrentPrice current_price = new CurrentPrice();
		current_price.setCurrencyCode("USD");
		current_price.setcurrentValue(new BigDecimal(String.valueOf(13.49)));

		Product mockedProduct = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", current_price);

		Mockito.when(productServiceMock.getProductById(Mockito.anyString())).thenReturn(mockedProduct);
		String apiUrl = "http://localhost:8080/v1/products/13860428";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON_VALUE);

		// Actual Result
		MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
		int aR = actualResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), aR);
		// Expected result
		// String expectedResult = "{\"id\": \"13860428\",\"name\": \"The Big Lebowski
		// (Blu-ray) (Widescreen)\",\"current_price\": {\"value\":
		// 13.49,\"currency_code\": \"USD\"}}";
		// JSONAssert.assertEquals(expectedResult,
		// actualResult.getResponse().getContentAsString(), true);

	}

	@Test()
	public void getProductDetailsTest_productNotFound() throws Exception {
		Mockito.when(productServiceMock.getProductById(Mockito.anyString())).thenThrow(new NullPointerException());

		try {
			String apiUrl = "v1/products/138604289";

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(apiUrl).accept(MediaTypes.ALPS_JSON_VALUE);
			mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}

	@Test
	public void updateProductTest() throws Exception {
		CurrentPrice current_price = new CurrentPrice();
		current_price.setCurrencyCode("USD");
		current_price.setcurrentValue(new BigDecimal(String.valueOf(13.49)));
		Product mockedProduct = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", current_price);
		ResponseEntity<Product> mockedResProduct = new ResponseEntity<Product>(mockedProduct, HttpStatus.OK);

		Mockito.when(productControllerMocked.updateProduct("13860428", mockedProduct)).thenReturn(mockedResProduct); // productServiceMock.updateProduct(Mockito.any())).thenReturn(mockedProduct);

		String apiUrl = "http://localhost:8080/v1/products/13860428";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON_VALUE);

		// Actual Result
		MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
		int aR = actualResult.getResponse().getStatus();
		// Expected result
		// String expectedResult = "{\"id\": \"13860428\",\"name\": \"The Big Lebowski
		// (Blu-ray) (Widescreen)\",\"current_price\": {\"value\":
		// 13.49,\"currency_code\": \"USD\"}}";
		// JSONAssert.assertEquals(expectedResult,
		// actualResult.getResponse().getContentAsString(), true);
		assertEquals(HttpStatus.OK.value(), aR);
	}

	/*
	 * Some of the other test cases are update
	 */
}
