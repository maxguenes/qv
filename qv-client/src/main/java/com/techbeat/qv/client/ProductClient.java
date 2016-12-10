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

import com.techbeat.qv.models.Product;

public class ProductClient extends QvClient{

	public ProductClient(String qvServiceUrl) throws MalformedURLException {
		super(qvServiceUrl);
	}
	
	public List<Product> list() {
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.set("Connection", "Close");

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(parts,
				headers);
			
    	ResponseEntity<Product[]> result = template.exchange(getQvProductServiceEndpointURL("list"), HttpMethod.GET, requestEntity,
    			Product[].class);
    	return Arrays.asList(result.getBody());
    }

	public Product save(Product Product){
		MultiValueMap<String, String> headers = 
				new LinkedMultiValueMap<String, String>(); 
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Connection", "Close");

		HttpEntity<Product> entity = new HttpEntity<Product>(Product, headers); 
		
    	ResponseEntity<Product> result = template.exchange(getQvProductServiceEndpointURL("save"), HttpMethod.POST, entity,
    			Product.class);
    	return result.getBody();
	}
	
	public Product get(int id) {
		return template.exchange(getQvProductServiceEndpointURL("get/"+id), HttpMethod.GET, null,
    			Product.class).getBody();
	}
	
	public boolean remove(int id) {
		return template.exchange(getQvProductServiceEndpointURL("remove/"+id), HttpMethod.DELETE, null,
    			Boolean.class).getBody();
	}

	private String getQvProductServiceEndpointURL(String endpoint) {
		return getQvServiceEndpointURL("product/"+endpoint);
	}
	
	
	
}
