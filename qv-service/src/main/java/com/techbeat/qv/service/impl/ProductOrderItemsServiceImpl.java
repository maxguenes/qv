package com.techbeat.qv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techbeat.qv.database.entity.ProductOrderItemsEntity;
import com.techbeat.qv.database.repository.ProductOrderItemsRepository;
import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.exceptions.ExceptionStockInsufficient;
import com.techbeat.qv.service.ProductOrderItemsService;
import com.techbeat.qv.service.StockService;
import com.techbeat.qv.service.converter.ProductOrderItemsConverter;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Component
public class ProductOrderItemsServiceImpl implements ProductOrderItemsService{
	
	@Autowired
	private ProductOrderItemsRepository productOrderItemsRepository;
	
	@Autowired
	private StockService stockService;
	
	@Override
	public ProductOrderItems save(ProductOrderItems productOrderItems)  throws ExceptionStockInsufficient {
		
		Boolean isExistProductStock = stockService.isExistStock(productOrderItems.getProduct());
		
		if (isExistProductStock)
			throw new ExceptionStockInsufficient("ESTOQUE INSUFICIENTE");
		
		
		ProductOrderItemsEntity entity = ProductOrderItemsConverter.convert(productOrderItems);
		ProductOrderItemsEntity saved = productOrderItemsRepository.save(entity);

		return ProductOrderItemsConverter.convert(saved);
		
	}
	
	
	@Override
	public ProductOrderItems find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
