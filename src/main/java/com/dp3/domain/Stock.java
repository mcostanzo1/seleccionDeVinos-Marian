package com.dp3.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.hibernate.jpamodelgen.xml.jaxb.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

@Document(collection = "stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	protected String stockCode;
	protected String productName;
	protected String quantityOnStockBox;
	protected String price;

	public Stock() {
	}

	public String getStockCode() {
		return stockCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityOnStockBox() {
		return quantityOnStockBox;
	}

	public void setQuantityOnStockBox(String quantityOnStockBox) {
		this.quantityOnStockBox = quantityOnStockBox;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
