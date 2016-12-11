package com.techbeat.qv.client;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.Status;
import com.techbeat.qv.models.User;

public class ProductOrderClient extends QvClient{

	public ProductOrderClient(String qvServiceUrl) throws MalformedURLException {
		super(qvServiceUrl);
	}
	
	public List<ProductOrder> list() {
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.set("Connection", "Close");

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(parts,
				headers);
			
    	ResponseEntity<ProductOrder[]> result = template.exchange(getQvProductOrderServiceEndpointURL("list"), HttpMethod.GET, requestEntity,
    			ProductOrder[].class);
    	return Arrays.asList(result.getBody());
    }
	
	public List<ProductOrder> listUserOrder(User user){
		MultiValueMap<String, String> headers = 
				new LinkedMultiValueMap<String, String>(); 
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Connection", "Close");

		HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
		
    	ResponseEntity<ProductOrder[]> result = template.exchange(getQvProductOrderServiceEndpointURL("listUserOrder"), HttpMethod.POST, entity,
    			ProductOrder[].class);
    	return Arrays.asList(result.getBody());
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
			if(e.getResponseBodyAsString().contains("Insuficient Stock")){
				return new ProductOrder(Status.INSUFFICIENT_STOCK);
			}
			
			throw e;
		}
		
	}
	
	public ProductOrder get(int id) {
		return template.exchange(getQvProductOrderServiceEndpointURL("get/"+id), HttpMethod.GET, null,
				ProductOrder.class).getBody();
	}
	
	private String getQvProductOrderServiceEndpointURL(String endpoint) {
		return getQvServiceEndpointURL("productOrder/"+endpoint);
	}
	
}
