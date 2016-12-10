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

import com.techbeat.qv.models.Product;
import com.techbeat.qv.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
    public  List<Product> list() {
		return productService.list();
	}
	
	@ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") int id) {
        return productService.find(id);
    }

    @ResponseBody
    @RequestMapping(value= "/save", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> remove(@PathVariable("id") int id){
        boolean result = productService.delete(id);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
}
