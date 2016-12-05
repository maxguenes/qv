package com.techbeat.qv.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public abstract class QvClient {
	
	private URL qvServiceURL;
	protected RestTemplate template;
	
	public QvClient(String qvServiceUrl) throws MalformedURLException {
		this(new URL(qvServiceUrl));
	}

	public QvClient(URL snuServiceURL){
		System.setProperty("http.keepAlive", "false");
		this.qvServiceURL = snuServiceURL;
		template = new RestTemplate();
		
		if(template.getMessageConverters() == null){
			template.setMessageConverters(new ArrayList<HttpMessageConverter<?>>());
		}
		
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		template.getMessageConverters().add(new FormHttpMessageConverter());
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	}
	
	public URL getQvServiceURL() {
		return qvServiceURL;
	}
	
	public String getQvServiceEndpointURL(String endpoint) {
		return qvServiceURL.toString()+"/"+endpoint;
	}
}
