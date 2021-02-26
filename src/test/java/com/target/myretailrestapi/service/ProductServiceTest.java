package com.target.myretailrestapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.target.myretailrestapi.model.CurrentPrice;
import com.target.myretailrestapi.model.Product;
import com.target.myretailrestapi.redskyservice.impl.RedSkyServiceImpl;
import com.target.myretailrestapi.repository.ProductRepository;
import com.target.myretailrestapi.service.impl.ProductServiceImpl;

@WebMvcTest(value = ProductService.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductRepository productRepoMock;

	@MockBean
	RedSkyServiceImpl redSkyServiceMock;

	@InjectMocks
	ProductServiceImpl productServiceMock;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getProductByIdTest() throws Exception {
		CurrentPrice current_price = new CurrentPrice();
		current_price.setCurrencyCode("USD");
		current_price.setcurrentValue(new BigDecimal(String.valueOf(13.49)));

		Product mockedProduct = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", current_price);

		Mockito.when(productRepoMock.getProductById("13860428")).thenReturn(mockedProduct);
		Product actualProduct = productServiceMock.getProductDetails("13860428");
		assertEquals(mockedProduct, actualProduct);
	}

	@Test
	public void updateInvalidProduct() throws Exception {
		CurrentPrice current_price = new CurrentPrice();
		current_price.setCurrencyCode("USD");
		current_price.setcurrentValue(new BigDecimal(String.valueOf(13.49)));

		Product mockedProduct = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", current_price);

		Mockito.when(productRepoMock.save(mockedProduct)).thenReturn(mockedProduct);
		Product actualProduct = productServiceMock.updateProduct(mockedProduct);
		assertEquals(mockedProduct, actualProduct);
	}
}
