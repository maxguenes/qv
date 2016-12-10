package com.techbeat.qv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techbeat.qv.database.entity.StockEntity;
import com.techbeat.qv.database.repository.StockRepository;
import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.Stock;
import com.techbeat.qv.models.exceptions.QVException;
import com.techbeat.qv.service.StockService;
import com.techbeat.qv.service.converter.StockConverter;

@Component
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;


	@Override
	public Stock save(Stock stock) {
		StockEntity entity = null;
		
		if(stock.getId()!=null){
			entity = stockRepository.findOne(stock.getId());
		}else if(stock.getProduct()!=null && stock.getProduct().getId()!=null){
			entity = stockRepository.findByProduct_id(stock.getProduct().getId());
		}
		
		if(entity == null){
			throw new QVException("Not Found");
		}
		
		entity.setQuantitiy(entity.getQuantitiy()+stock.getQuantitiy());
		
		StockEntity saved = stockRepository.save(entity);
		return StockConverter.convert(saved);
	}

	@Override
	public boolean delete(int id) {
		stockRepository.delete(id);
		return true;
	}

	@Override
	public boolean isExistStock(List<ProductOrderItems> productOrderItems) {
		
		if(productOrderItems == null || productOrderItems.isEmpty()){
			return true;
		}
		
		synchronized (stockRepository)
		{

			for(ProductOrderItems orderItem : productOrderItems){
				StockEntity stock = stockRepository.findByProduct_id(orderItem.getProduct().getId());
				if(stock.getQuantitiy() < orderItem.getQuantitiy()){
					return false;
				}
			}
		}
		
		return true;
	}

}
