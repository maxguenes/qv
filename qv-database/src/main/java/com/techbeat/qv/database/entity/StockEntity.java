package com.techbeat.qv.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Entity(name = "stock")
public class StockEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;

    @Column(name="quantity", nullable = false)
    private int quantitiy;

    @Column(name="update_date", nullable = false)
    private Date updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(int quantitiy) {
        this.quantitiy = quantitiy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
