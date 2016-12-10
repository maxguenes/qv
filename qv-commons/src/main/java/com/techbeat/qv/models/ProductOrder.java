package com.techbeat.qv.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
public class ProductOrder{

    private Integer id;

    private User user;

    private Date registerDate;

    private Date deliveryDate;

    private int status;
    
    private List<ProductOrderItems> orderItems = new ArrayList<>();

    public ProductOrder() {
		// TODO Auto-generated constructor stub
	}
    
    public ProductOrder(Status status){
    	this.status = status.getStatusValue();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public List<ProductOrderItems> getOrderItems() {
		return orderItems;
	}
    
    public void setOrderItems(List<ProductOrderItems> orderItems) {
		this.orderItems = orderItems;
	}

}
