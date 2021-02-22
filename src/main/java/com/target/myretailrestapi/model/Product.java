package com.target.myretailrestapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty
	public String id;
	public String name;
	public CurrentPrice current_price;

	public Product(String id, String name, CurrentPrice current_price) {
		this.id = id;
		this.name = name;
		this.current_price = current_price;
	}

	public Product() {
	}

	public String getProductid(String id) {
		return id;
	}

	public void setProductid(String id) {
		this.id = id;
	}

	public String getProductName(String name) {
		return name;
	}

	public void setProductName(String name) {
		this.name = name;
	}

	public CurrentPrice getCurrentPrice(CurrentPrice current_price) {
		return current_price;
	}

	public void setCurrentPrice(CurrentPrice current_price) {
		this.current_price = current_price;
	}
}
