package com.techbeat.qv.service;

import java.util.List;

import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.Stock;


public interface StockService {

	Stock save(Stock stock);
	
	List<Stock> list();
	
	Stock get(int id);
	
	boolean isExistStock (List<ProductOrderItems> productOrderItems);
	
}
