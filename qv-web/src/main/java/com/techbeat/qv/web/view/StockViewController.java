package com.techbeat.qv.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techbeat.qv.models.Stock;
import com.techbeat.qv.service.StockService;

@Controller
@RequestMapping("/view/stock")
public class StockViewController {

	@Autowired
	private StockService stockService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("stockList", stockService.list());
        return "stock/index";
    }
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editStock(@PathVariable("id") int id, Model model) {
        model.addAttribute("stock", this.stockService.get(id));
        return "stock/edit";
    }
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
    public String saveStock(@ModelAttribute("stock") Stock stock, Model model){
        this.stockService.save(stock);
        return index(model);
    }
	
}
