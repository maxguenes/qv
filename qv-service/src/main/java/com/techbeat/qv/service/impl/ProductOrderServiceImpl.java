package com.techbeat.qv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.database.repository.ProductOrderRepository;
import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.service.ProductOrderService;
import com.techbeat.qv.service.converter.ProductOrderConverter;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Component
public class ProductOrderServiceImpl implements ProductOrderService{
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	
	

	@Override
	public ProductOrder save(ProductOrder productOrder) {
		
		ProductOrderEntity entity = ProductOrderConverter.convert(productOrder);
		ProductOrderEntity saved = productOrderRepository.save(entity);
		return ProductOrderConverter.convert(saved);
	}


	
	
}
