package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.ProductEntity;
import com.techbeat.qv.models.Product;

public class ProductConverter {

	public static Product convert(ProductEntity p)
	{
		
		if(p==null){
			return null;
		}
		
		Product result = new Product();
		
		result.setId(p.getId());
		result.setName(p.getName());
		result.setValue(p.getValue());
		result.setUnit(p.getUnit());
		
		return result;
	}
	
	public static List<Product> convertToModelList(Iterable<ProductEntity> p)
	{
		
		if(p == null){
			return null;
		}
		
		List<Product> result = new ArrayList<>();
		for(ProductEntity entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static List<ProductEntity> convertToEntityList(Iterable<Product> p)
	{
		
		if(p == null){
			return null;
		}
		
		List<ProductEntity> result = new ArrayList<>();
		for(Product entity : p){
			result.add(convert(entity));
		}
		
		return result;
	}
	
	public static ProductEntity convert(Product p)
	{
		
		if(p == null){
			return null;
		}
		
		ProductEntity result = new ProductEntity();
		
		result.setId(p.getId());
		result.setName(p.getName());
		result.setValue(p.getValue());
		result.setUnit(p.getUnit());
		
		return result;
	}
	
}
