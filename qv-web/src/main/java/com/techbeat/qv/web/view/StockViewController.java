package com.techbeat.qv.web.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techbeat.qv.models.Product;
import com.techbeat.qv.models.Stock;
import com.techbeat.qv.models.Unit;
import com.techbeat.qv.service.ProductService;
import com.techbeat.qv.service.StockService;

@Controller
@RequestMapping("/view/stock")
public class StockViewController {

	@Autowired
	private StockService stockService;
	
	@Autowired
	private ProductService productService;
	
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
	
	@RequestMapping(value = "new", method = RequestMethod.GET)
    public String newProduct(Model model) {
		model.addAttribute("units", Unit.values());
        return "stock/new";
    }
	
	@RequestMapping(value= "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product, Model model){
        this.productService.save(product);
        return index(model);
    }
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
    public String saveStock(@ModelAttribute("stock") Stock stock, Model model){
        this.stockService.save(stock);
        return index(model);
    }
	
}
