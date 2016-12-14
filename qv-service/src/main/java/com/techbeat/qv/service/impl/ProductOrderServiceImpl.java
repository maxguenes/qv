package com.techbeat.qv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techbeat.qv.database.entity.ProductOrderEntity;
import com.techbeat.qv.database.entity.ProductOrderItemsEntity;
import com.techbeat.qv.database.entity.StockEntity;
import com.techbeat.qv.database.entity.UserEntity;
import com.techbeat.qv.database.repository.ProductOrderItemsRepository;
import com.techbeat.qv.database.repository.ProductOrderRepository;
import com.techbeat.qv.database.repository.StockRepository;
import com.techbeat.qv.database.repository.UserRepository;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.Status;
import com.techbeat.qv.models.User;
import com.techbeat.qv.models.exceptions.InsufficientStockException;
import com.techbeat.qv.service.ProductOrderService;
import com.techbeat.qv.service.converter.ProductOrderConverter;
import com.techbeat.qv.service.converter.ProductOrderItemsConverter;
import com.techbeat.qv.service.converter.UserConverter;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Component
public class ProductOrderServiceImpl implements ProductOrderService{
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Autowired
	private ProductOrderItemsRepository productOrderItemsRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	@Transactional
	public ProductOrder save(ProductOrder productOrder) throws InsufficientStockException {
		
		synchronized (stockRepository)
		{
			List<Product> insuficientStockProducts = new ArrayList<>();
			for(ProductOrderItems orderItem : productOrder.getOrderItems()){
				StockEntity stock = stockRepository.findByProduct_id(orderItem.getProduct().getId());
				if(stock.getQuantitiy() < orderItem.getQuantitiy()){
					insuficientStockProducts.add(orderItem.getProduct());
				}else{
					if(insuficientStockProducts.isEmpty()){
						stock.setQuantitiy(stock.getQuantitiy()-orderItem.getQuantitiy());
						stockRepository.save(stock);
					}
				}
			}
			
			if(!insuficientStockProducts.isEmpty()){
				throw new InsufficientStockException(insuficientStockProducts);
			}
		}
		
		
		
		ProductOrderEntity entity = null;
		
		if(productOrder.getId()==null) {
			productOrder.setStatus(Status.WAITING_PAYMENT.getStatusValue());
			entity = ProductOrderConverter.convert(productOrder);
		}else{
			entity = productOrderRepository.findOne(productOrder.getId());
			entity.setStatus(productOrder.getStatus());
		}
		
		
		if(productOrder.getUser()!=null && productOrder.getUser().getId()==null){
			UserEntity user = userRepository.findByEmail(productOrder.getUser().getEmail());
			entity.setUser(user);
		}
		
		ProductOrderEntity saved = productOrderRepository.save(entity);
		
		for(ProductOrderItems items : productOrder.getOrderItems()){
			ProductOrderItemsEntity itemEntity = ProductOrderItemsConverter.convert(items);
			itemEntity.setProductOrder(saved);
			productOrderItemsRepository.save(itemEntity);
		}
		
		return ProductOrderConverter.convert(saved);
	}

	@Override
	public List<ProductOrder> list() {
		Iterable<ProductOrderEntity> found = productOrderRepository.findAll();
		return ProductOrderConverter.convertToModelList(found);
	}

	@Override
	public List<ProductOrder> listUserOrders(User user) {
		List<ProductOrderEntity> found = null;
		if(user.getId()!=null){
			found = productOrderRepository.findByUser(UserConverter.convert(user));
		}else{
			found = productOrderRepository.findByUser_email(user.getEmail());
		}
		
		return ProductOrderConverter.convertToModelList(found);
	}

	@Override
	public ProductOrder find(int id) {
		ProductOrderEntity found = productOrderRepository.findOne(id);
		return ProductOrderConverter.convert(found);
	}
	
}
