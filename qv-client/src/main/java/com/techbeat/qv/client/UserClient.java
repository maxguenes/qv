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

import com.techbeat.qv.models.User;

public class UserClient extends QvClient{

	public UserClient(String qvServiceUrl) throws MalformedURLException {
		super(qvServiceUrl);
	}
	
	public List<User> list() {
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.set("Connection", "Close");

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(parts,
				headers);
			
    	ResponseEntity<User[]> result = template.exchange(getQvUserServiceEndpointURL("list"), HttpMethod.GET, requestEntity,
    			User[].class);
    	return Arrays.asList(result.getBody());
    }

	public User save(User User){
		MultiValueMap<String, String> headers = 
				new LinkedMultiValueMap<String, String>(); 
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Connection", "Close");

		HttpEntity<User> entity = new HttpEntity<User>(User, headers); 
		
    	ResponseEntity<User> result = template.exchange(getQvUserServiceEndpointURL("save"), HttpMethod.POST, entity,
    			User.class);
    	return result.getBody();
	}
	
	public User get(int id) {
		return template.exchange(getQvUserServiceEndpointURL("get/"+id), HttpMethod.GET, null,
    			User.class).getBody();
	}
	
	public boolean remove(int id) {
		return template.exchange(getQvUserServiceEndpointURL("remove/"+id), HttpMethod.DELETE, null,
    			Boolean.class).getBody();
	}

	private String getQvUserServiceEndpointURL(String endpoint) {
		return getQvServiceEndpointURL("user/"+endpoint);
	}
	
	
	
}
