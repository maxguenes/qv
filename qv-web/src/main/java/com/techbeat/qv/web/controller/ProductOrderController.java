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

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.service.ProductOrderService;

@Controller
@RequestMapping("/productOrder")
public class ProductOrderController {

	@Autowired
	private ProductOrderService productOrderService;

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrder> save(@RequestBody ProductOrder productOrder){
		ProductOrder result = productOrderService.save(productOrder);
		return new ResponseEntity<ProductOrder>(result, HttpStatus.OK);
	}

}
