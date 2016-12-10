package com.techbeat.qv.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.database.entity.ProductEntity;
import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.database.entity.ProductOrderItemsEntity;
import com.techbeat.qv.database.entity.UserEntity;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.User;

public class ProductOrderItemsConverter {

	public static ProductOrderItems convert(ProductOrderItemsEntity p)
	{
		
		if(p==null){
			return null;
		}
		
		ProductOrderItems result = new ProductOrderItems();
		Product product = new Product();
		ProductOrder productOrder = new ProductOrder();
		User user = new User();
		
		
		user.setEmail(p.getProductOrder().getUser().getEmail());
		user.setId(p.getProductOrder().getUser().getId());
		user.setName(p.getProductOrder().getUser().getName());
		user.setRegisterDate(p.getProductOrder().getUser().getRegisterDate());
		
		product.setId(p.getProduct().getId());
		product.setName(p.getProduct().getName());
		product.setValue(p.getProduct().getValue());
		result.setProduct(product);
		
		productOrder.setDeliveryDate(p.getProductOrder().getDeliveryDate());
		productOrder.setId(p.getProductOrder().getId());
		productOrder.setStatus(p.getProductOrder().getStatus());
		productOrder.setRegisterDate(p.getProductOrder().getRegisterDate());
		productOrder.setUser(user);
		result.setOrder(productOrder);
		
		result.setId(p.getId());
		result.setQuantitiy(p.getQuantitiy());
		
		
		return result;
	}
	
	public static List<ProductOrderItems> convert(Iterable<ProductOrderItemsEntity> p){
		
		if(p == null){
			return null;
		}
		
		List<ProductOrderItems> result = new ArrayList<>();
		for(ProductOrderItemsEntity entity : p){
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
		
		ProductEntity productEntity = new ProductEntity();
		UserEntity userEntity = new UserEntity();
		ProductOrderEntity productOrderEntity = new ProductOrderEntity();
		
		productEntity.setId(p.getProduct().getId());
		productEntity.setName(p.getProduct().getName());
		productEntity.setValue(p.getProduct().getValue());
		result.setProduct(productEntity);
		
		userEntity.setEmail(p.getOrder().getUser().getEmail());
		userEntity.setName(p.getOrder().getUser().getName());
		userEntity.setId(p.getOrder().getId());
		userEntity.setRegisterDate(p.getOrder().getRegisterDate());
		
	
		
		productOrderEntity.setDeliveryDate(p.getOrder().getDeliveryDate());
		productOrderEntity.setId(p.getOrder().getId());
		productOrderEntity.setRegisterDate(p.getOrder().getRegisterDate());		
		productOrderEntity.setStatus(p.getOrder().getStatus());
		productOrderEntity.setUser(userEntity);
		result.setId(p.getId());
		result.setProductOrder(productOrderEntity);
		result.setQuantitiy(p.getQuantitiy());
		
		return result;
	}
	
}
