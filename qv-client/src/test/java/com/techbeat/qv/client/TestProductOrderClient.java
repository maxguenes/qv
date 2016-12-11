package com.techbeat.qv.client;


import java.util.ArrayList;
import java.util.List;

import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.User;

public class TestProductOrderClient {

	public static final String URL = "http://localhost:8080/qv-web/";
	
	public static void main(String[] args) throws Exception{
		ProductOrderClient client = new ProductOrderClient(URL);
		
		User user = new User();
//		user.setId(1);
		user.setEmail("admin@admin.com");
		List<ProductOrder> listUserOrder = client.listUserOrder(user);
		System.out.println(listUserOrder);
	}
	
	
	public static void main2(String[] args) throws Exception{
		ProductOrderClient client = new ProductOrderClient(URL);
		ProductClient productsClient = new ProductClient(URL);
		ProductOrder order = new ProductOrder();
		
		User user = new User();
		user.setEmail("admin@admin.com");
		order.setUser(user);
		
		List<Product> list = productsClient.list();

		List<ProductOrderItems> orderItems = new ArrayList<>();
		
		
		{
			ProductOrderItems item = new ProductOrderItems();
			item.setProduct(list.get(0));
			item.setQuantitiy(6);
			orderItems.add(item);
		}
		
		{
			ProductOrderItems item = new ProductOrderItems();
			item.setProduct(list.get(1));
			item.setQuantitiy(6);
			orderItems.add(item);
		}
		
		{
			ProductOrderItems item = new ProductOrderItems();
			item.setProduct(list.get(2));
			item.setQuantitiy(6);
			orderItems.add(item);
		}
		
		order.setOrderItems(orderItems);
		
		
		ProductOrder saved = client.save(order);
		System.out.println(saved);

	}
	
}
