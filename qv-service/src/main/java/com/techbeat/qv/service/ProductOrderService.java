package com.techbeat.qv.service;

import java.util.List;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.User;
import com.techbeat.qv.models.exceptions.InsufficientStockException;

public interface ProductOrderService {
	
	ProductOrder save(ProductOrder productOrder) throws InsufficientStockException;
	
	List<ProductOrder> list();
	
	List<ProductOrder> listUserOrders(User user);
	
}
