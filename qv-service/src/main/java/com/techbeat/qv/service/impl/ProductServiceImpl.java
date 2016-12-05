package com.techbeat.qv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techbeat.qv.database.entity.ProductEntity;
import com.techbeat.qv.database.repository.ProductRepository;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.service.ProductService;
import com.techbeat.qv.service.converter.ProductConverter;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> list() {
		Iterable<ProductEntity> found = productRepository.findAll();
		return ProductConverter.convert(found);
	}

	@Override
	public Product find(int id) {
		return ProductConverter.convert(productRepository.findOne(id));
	}

	@Override
	public Product save(Product product) {
		ProductEntity entity = ProductConverter.convert(product);
		ProductEntity saved = productRepository.save(entity);
		return ProductConverter.convert(saved);
	}

	@Override
	public boolean delete(int id) {
		productRepository.delete(id);
		return true;
	}
	
}
