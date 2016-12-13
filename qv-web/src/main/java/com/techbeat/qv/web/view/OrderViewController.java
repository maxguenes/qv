package com.techbeat.qv.web.view;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techbeat.qv.models.ProductOrder;
import com.techbeat.qv.models.Status;
import com.techbeat.qv.service.ProductOrderService;

@Controller
@RequestMapping("/view/order")
public class OrderViewController {

	@Autowired
	private ProductOrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("orderList", orderService.list());
        return "order/index";
    }
	
	@RequestMapping(value= "/delivering/{id}", method = RequestMethod.GET)
    public String deliverOrder(@PathVariable("id") int id, Model model){
		ProductOrder order = new ProductOrder();
		order.setId(id);
		order.setDeliveryDate(new Date());
		order.setStatus(Status.IN_DELIVERY.getStatusValue());
        this.orderService.save(order);
        return index(model);
    }
	
	
	@RequestMapping(value= "/delivered/{id}", method = RequestMethod.GET)
    public String deliveredOrder(@PathVariable("id") int id, Model model){
		ProductOrder order = new ProductOrder();
		order.setId(id);
		order.setStatus(Status.DELIVERED.getStatusValue());
		this.orderService.save(order);
        return index(model);
    }
}
