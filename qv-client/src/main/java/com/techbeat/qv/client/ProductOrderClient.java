package com.techbeat.qv.client;

import java.net.MalformedURLException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.Status;

public class ProductOrderClient extends QvClient{

	public ProductOrderClient(String qvServiceUrl) throws MalformedURLException {
		super(qvServiceUrl);
	}
	
	public ProductOrder save(ProductOrder productOrder) {
		try{
			MultiValueMap<String, String> headers = 
					new LinkedMultiValueMap<String, String>(); 
			headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			headers.set("Connection", "Close");
	
			HttpEntity<ProductOrder> entity = new HttpEntity<ProductOrder>(productOrder, headers); 
			
	    	return template.exchange(getQvProductOrderServiceEndpointURL("save"), HttpMethod.POST, entity,
	    			ProductOrder.class).getBody();
		}catch (HttpClientErrorException e) {
			if(e.getRawStatusCode() == 400 && e.getResponseBodyAsString().contains("Insuficient Stock")){
				return new ProductOrder(Status.INSUFFICIENT_STOCK);
			}
			
			throw e;
		}
		
	}
	
	private String getQvProductOrderServiceEndpointURL(String endpoint) {
		return getQvServiceEndpointURL("productOrder/"+endpoint);
	}
	
}
