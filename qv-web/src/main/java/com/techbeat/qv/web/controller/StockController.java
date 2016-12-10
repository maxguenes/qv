package com.techbeat.qv.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techbeat.qv.models.Stock;
import com.techbeat.qv.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
    @ResponseBody
    @RequestMapping(value= "/save", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Stock save(@RequestBody Stock stock){
        return stockService.save(stock);
    }
}
