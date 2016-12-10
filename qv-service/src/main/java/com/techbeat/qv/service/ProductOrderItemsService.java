package com.techbeat.qv.service;

import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.exceptions.ExceptionStockInsufficient;


public interface ProductOrderItemsService {

	ProductOrderItems save(ProductOrderItems productOrderItems)  throws ExceptionStockInsufficient;
	ProductOrderItems find(int id);
	
	
}
