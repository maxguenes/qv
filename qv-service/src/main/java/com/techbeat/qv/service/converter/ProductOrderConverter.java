package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.database.entity.UserEntity;
import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.User;

public class ProductOrderConverter {

	public static ProductOrder convert(ProductOrderEntity p)
	{
		
		if(p==null){
			return null;
		}
		
		ProductOrder result = new ProductOrder();
		User user = new User();
		user.setEmail(p.getUser().getEmail());
		user.setName(p.getUser().getName());
		user.setRegisterDate(p.getUser().getRegisterDate());
		user.setId(p.getUser().getId());
		result.setUser(user);
		result.setStatus(p.getStatus());
		result.setRegisterDate(p.getRegisterDate());
		result.setId(p.getId());
		
		return result;
	}
	
	public static List<ProductOrder> convert(Iterable<ProductOrderEntity> p)
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
		
		UserEntity userEntity = new UserEntity();

		userEntity.setEmail(p.getUser().getEmail());
		userEntity.setName(p.getUser().getName());
		userEntity.setId(p.getUser().getId());
		userEntity.setRegisterDate(p.getUser().getRegisterDate());
		
		result.setUser(userEntity);
		result.setDeliveryDate(p.getDeliveryDate());
		result.setRegisterDate(p.getRegisterDate());
		result.setStatus(p.getStatus());
		result.setId(p.getId());
		
		return result;
	}
	
}
