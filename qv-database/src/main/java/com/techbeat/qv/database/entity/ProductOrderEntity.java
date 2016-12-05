package com.techbeat.qv.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Entity(name = "product_order")
public class ProductOrderEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "register_date", nullable = false)
    private Date registerDate;

    @Column(name = "delivery_date ", nullable = false)
    private Date deliveryDate;

    @Column(name = "status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @PrePersist
    protected void onCreate() {
        registerDate = new Date();
    }

}
