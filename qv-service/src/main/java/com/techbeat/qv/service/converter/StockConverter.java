package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.StockEntity;
import com.techbeat.qv.models.Stock;

public class StockConverter {

	public static Stock convert(StockEntity p){
		
		if(p==null){
			return null;
		}
		
		Stock result = new Stock();
		
		result.setId(p.getId());
		result.setProduct(ProductConverter.convert(p.getProduct()));
		result.setQuantitiy(p.getQuantitiy());
	
		return result;
	}
	
	public static List<Stock> convertToModelList(Iterable<StockEntity> p)
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
		
		
		result.setId(p.getId());
		result.setQuantitiy(p.getQuantitiy());
		result.setProduct(ProductConverter.convert(p.getProduct()));
		
		return result;
	}
	
}
