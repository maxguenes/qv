package com.techbeat.qv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techbeat.qv.database.entity.ProductEntity;
import com.techbeat.qv.database.entity.StockEntity;
import com.techbeat.qv.database.repository.ProductRepository;
import com.techbeat.qv.database.repository.StockRepository;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.Stock;
import com.techbeat.qv.service.ProductService;
import com.techbeat.qv.service.converter.ProductConverter;
import com.techbeat.qv.service.converter.StockConverter;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public List<Product> list() {
		Iterable<ProductEntity> found = productRepository.findAll();
		return ProductConverter.convertToModelList(found);
	}

	@Override
	public Product find(int id) {
		return ProductConverter.convert(productRepository.findOne(id));
	}

	@Override
	@Transactional
	public Product save(Product product) {
		ProductEntity entity = ProductConverter.convert(product);
		ProductEntity saved = productRepository.save(entity);
		
		if(product.getStock()==null){
			Stock stock = new Stock();
			stock.setQuantitiy(0);
			product.setStock(stock);
		}

		StockEntity stockEntity = StockConverter.convert(product.getStock());
		stockEntity.setProduct(saved);
		stockRepository.save(stockEntity);
		
		return ProductConverter.convert(saved);
	}

	@Override
	public boolean delete(int id) {
		productRepository.delete(id);
		return true;
	}
	
}
