package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.ProductEntity;
import com.techbeat.qv.database.entity.StockEntity;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.Stock;

public class StockConverter {

	public static Stock convert(StockEntity p){
		
		if(p==null){
			return null;
		}
		
		Stock result = new Stock();
		Product product = new Product();
		
		product.setId(p.getProduct().getId());
		product.setName(p.getProduct().getName());
		product.setValue(p.getProduct().getValue());
	
		result.setId(p.getId());
		result.setProduct(product);
		result.setQuantitiy(p.getQuantitiy());
	
		return result;
	}
	
	public static List<Stock> convert(Iterable<StockEntity> p)
	{
		
		if(p == null){
			return null;
		}
		
		List<Stock> result = new ArrayList<>();
		
		for(StockEntity entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static StockEntity convert(Stock p)
	{
		
		if(p == null){
			return null;
		}
		
		StockEntity result = new StockEntity();
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setId(p.getProduct().getId());
		productEntity.setName(p.getProduct().getName());
		productEntity.setValue(p.getProduct().getValue());
		
		result.setId(p.getId());
		result.setQuantitiy(p.getQuantitiy());
		result.setProduct(productEntity);
		
		return result;
	}
	
}
