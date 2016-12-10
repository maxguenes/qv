package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.ProductOrderItemsEntity;
import com.techbeat.qv.models.ProductOrderItems;

public class ProductOrderItemsConverter {

	public static ProductOrderItems convert(ProductOrderItemsEntity p)
	{
		
		if(p==null){
			return null;
		}
		
		
		ProductOrderItems result = new ProductOrderItems();
		result.setId(p.getId());
		result.setQuantitiy(p.getQuantitiy());
		
		return result;
	}
	
	public static List<ProductOrderItems> convertToModelList(Iterable<ProductOrderItemsEntity> p){
		
		if(p == null){
			return null;
		}
		
		List<ProductOrderItems> result = new ArrayList<>();
		for(ProductOrderItemsEntity entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static List<ProductOrderItemsEntity> convertToEntityList(Iterable<ProductOrderItems> p){
		
		if(p == null){
			return null;
		}
		
		List<ProductOrderItemsEntity> result = new ArrayList<>();
		for(ProductOrderItems entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static ProductOrderItemsEntity convert(ProductOrderItems p)
	{
		
		if(p == null){
			return null;
		}
		
		ProductOrderItemsEntity result = new ProductOrderItemsEntity();
		result.setProduct(ProductConverter.convert(p.getProduct()));
		result.setProductOrder(ProductOrderConverter.convert(p.getOrder()));
		result.setQuantitiy(p.getQuantitiy());
		
		return result;
	}
	
}
