package com.techbeat.qv.service;

import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.Stock;


public interface StockService {

	Stock save(Stock stock);
	boolean delete(int id);
	boolean isExistStock (Product product);
	
}
