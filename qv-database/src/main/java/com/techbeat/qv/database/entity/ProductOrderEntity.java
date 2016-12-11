package com.techbeat.qv.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Entity(name = "product_order")
public class ProductOrderEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "register_date", nullable = false)
    private Date registerDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "status", nullable = false)
    private int status;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productOrder")
    private List<ProductOrderItemsEntity> orderItems = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
    
    public List<ProductOrderItemsEntity> getOrderItems() {
		return orderItems;
	}
    
    public void setOrderItems(List<ProductOrderItemsEntity> orderItems) {
		this.orderItems = orderItems;
	}

    @PrePersist
    protected void onCreate() {
        registerDate = new Date();
    }

}
