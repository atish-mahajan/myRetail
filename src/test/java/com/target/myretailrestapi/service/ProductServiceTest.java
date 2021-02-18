package com.target.myretailrestapi.service;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

import com.target.myretailrestapi.model.CurrentPrice;
import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.repository.ProductRepository;
import com.target.myretailrestapi.service.ProductService;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
	@InjectMocks
	ProductService productService;
	
	@Mock
	ProductRepository productRepositorymock;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getProductByIdTest() throws Exception {
		CurrentPrice current_price = new CurrentPrice();
		current_price.setCurrencyCode("USD");
		current_price.setcurrentValue(new BigDecimal(String.valueOf(12.3)));
		
		Product mockedProduct = new Product("13860428", "The Big Lebowski (Blu-ray)", current_price);
		
		Mockito.when(productRepositorymock.findById(Mockito.anyString()).orElse(null)).thenReturn(mockedProduct);
		
		String expectedResult = "{\"id\": \"13860428\",\"name\": \"The Big Lebowski (Blu-ray)\",\"current_price\": {\"value\": \"50\",\"currency_code\": \"USD\"}}";
		
		assertEquals(expectedResult, productService.getProductById("13860428"));
	}
}
