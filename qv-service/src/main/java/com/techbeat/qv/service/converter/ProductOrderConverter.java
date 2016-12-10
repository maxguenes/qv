package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.models.ProductOrder;

public class ProductOrderConverter {

	public static ProductOrder convert(ProductOrderEntity p)
	{
		
		if(p==null){
			return null;
		}
		
		ProductOrder result = new ProductOrder();
		result.setUser(UserConverter.convert(p.getUser()));
		result.setStatus(p.getStatus());
		result.setRegisterDate(p.getRegisterDate());
		result.setId(p.getId());
		result.setOrderItems(ProductOrderItemsConverter.convertToModelList(p.getOrderItems()));
		
		return result;
	}
	
	public static List<ProductOrder> convertToModelList(Iterable<ProductOrderEntity> p)
	{
		
		if(p == null){
			return null;
		}
		
		List<ProductOrder> result = new ArrayList<>();
		for(ProductOrderEntity entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static ProductOrderEntity convert(ProductOrder p)
	{
		
		if(p == null){
			return null;
		}
		
		ProductOrderEntity result = new ProductOrderEntity();
		
		result.setUser(UserConverter.convert(p.getUser()));
		result.setDeliveryDate(p.getDeliveryDate());
		result.setRegisterDate(p.getRegisterDate());
		result.setStatus(p.getStatus());
		result.setId(p.getId());
		result.setOrderItems(ProductOrderItemsConverter.convertToEntityList(p.getOrderItems()));
		
		return result;
	}
	
}
