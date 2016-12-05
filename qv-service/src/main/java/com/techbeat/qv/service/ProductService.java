package com.techbeat.qv.service;

import java.util.List;

import com.techbeat.qv.models.Product;

/**
 * Created by Max Guenes on 04/12/2016.
 */
public interface ProductService {
   
	List<Product> list();
	Product find(int id);
	Product save(Product product);
	boolean delete(int id);
	
}
