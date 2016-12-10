package com.techbeat.qv.client;

import java.net.MalformedURLException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.techbeat.qv.models.ProductOrderItems;

public class ProductOrderItemsClient extends QvClient{

	public ProductOrderItemsClient(String qvServiceUrl) throws MalformedURLException {
		super(qvServiceUrl);
	}
	
	public boolean saveOrder(ProductOrderItems productOrderItems) {
		MultiValueMap<String, String> headers = 
				new LinkedMultiValueMap<String, String>(); 
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Connection", "Close");

		HttpEntity<ProductOrderItems> entity = new HttpEntity<ProductOrderItems>(productOrderItems, headers); 
		
    	return template.exchange(getQvServiceEndpointURL("saveOrder"), HttpMethod.POST, entity,
    			Boolean.class).getBody();
		
	}
	
}
