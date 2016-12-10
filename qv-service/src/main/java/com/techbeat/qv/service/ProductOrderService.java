package com.techbeat.qv.service;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.exceptions.ExceptionStockInsufficient;

public interface ProductOrderService {

	
	ProductOrder save(ProductOrder productOrder) throws ExceptionStockInsufficient;
	
}
