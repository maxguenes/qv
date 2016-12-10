package com.techbeat.qv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.techbeat.qv.database.entity.StockEntity;
import com.techbeat.qv.database.repository.StockRepository;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.Stock;
import com.techbeat.qv.service.StockService;
import com.techbeat.qv.service.converter.StockConverter;

public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;


	@Override
	public Stock save(Stock stock) {
		StockEntity entity = StockConverter.convert(stock);
		StockEntity saved = stockRepository.save(entity);
		return StockConverter.convert(saved);
	}

	@Override
	public boolean delete(int id) {
		stockRepository.delete(id);
		return true;
	}

	@Override
	public boolean isExistStock(Product product) {
		
		// TODO FAZER REGRA DE STOCK
		
		return false;
	}

}
