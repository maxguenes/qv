package com.techbeat.qv.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techbeat.qv.models.ProductOrderItems;
import com.techbeat.qv.models.exceptions.ExceptionStockInsufficient;
import com.techbeat.qv.service.ProductOrderItemsService;

@Controller
@RequestMapping("/ProductOrderItems")
public class ProductOrderItemsController {

	@Autowired
	private ProductOrderItemsService productOrderItemsService;
	
	 @ResponseBody
	 @RequestMapping(value= "/saveOrder", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Boolean> addOrder(@RequestBody ProductOrderItems productOrderItems) throws ExceptionStockInsufficient{
		 ProductOrderItems saved = productOrderItemsService.save(productOrderItems);
	     boolean result = (saved != null) ? Boolean.TRUE : Boolean.FALSE;

	     return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	 
	 }
	   
	
}
