package com.techbeat.qv.service;

import java.util.List;

import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.Stock;


public interface StockService {

	Stock save(Stock stock);
	
	List<Stock> list();
	
	boolean isExistStock (List<ProductOrderItems> productOrderItems);
	
}
