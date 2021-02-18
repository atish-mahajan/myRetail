package com.target.myretailrestapi.model;

import java.math.BigDecimal;

public class CurrentPrice {
	public BigDecimal value;
	public String currency_code;
	
	public BigDecimal getCurrentValue(BigDecimal value) {
		return value;
	}
	
	public void setcurrentValue(BigDecimal value) {
		this.value = value;
	}
	
	public String getCurrencyCode(String currency_code) {
		return currency_code;
	}
	
	public void setCurrencyCode(String currency_code) {
		this.currency_code = currency_code;
	}
}
