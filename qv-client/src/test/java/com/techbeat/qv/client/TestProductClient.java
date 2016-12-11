package com.techbeat.qv.client;

import org.junit.Assert;

import com.techbeat.qv.client.ProductClient;
import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.Unit;

public class TestProductClient {

	public static final String URL = "https://qvo-maxguenes.c9users.io:8081/qv-web";
	
	public static void main(String[] args) throws Exception{
		ProductClient client = new ProductClient(URL);
		
//		Product product = new Product();
//
//        product.setName("Banana");
//        product.setValue(1.10);
//        product.setUnit(Unit.UNIT);
//        
//        Product saved = client.save(product);
//        Assert.assertNotNull(saved);
//        Assert.assertTrue(saved.getId()>0);

        Product found = client.get(40);
        
        client.remove(found.getId());
	}
	
}
