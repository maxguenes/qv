package com.techbeat.qv.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.User;
import com.techbeat.qv.service.ProductOrderService;

@Controller
@RequestMapping("/productOrder")
public class ProductOrderController {

	@Autowired
	private ProductOrderService productOrderService;

	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
    public  List<ProductOrder> list() {
		return productOrderService.list();
	}
	
	@ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ProductOrder get(@PathVariable("id") int id) {
        return productOrderService.find(id);
    }
	
	@ResponseBody
	@RequestMapping(value = "/listUserOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductOrder> listUserOrder(@RequestBody User user){
		return productOrderService.listUserOrders(user);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrder> save(@RequestBody ProductOrder productOrder){
		ProductOrder result = productOrderService.save(productOrder);
		return new ResponseEntity<ProductOrder>(result, HttpStatus.OK);
	}

}
