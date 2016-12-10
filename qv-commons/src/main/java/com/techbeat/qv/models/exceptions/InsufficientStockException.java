package com.techbeat.qv.models.exceptions;

import java.util.List;

import com.techbeat.qv.models.Product;

public class InsufficientStockException extends QVException {
	
	private static final long serialVersionUID = 152288741707281315L;

	private List<Product> products;
	
	public InsufficientStockException(List<Product> products){
		super("Insufficient Stock");
		this.products = products;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
}
