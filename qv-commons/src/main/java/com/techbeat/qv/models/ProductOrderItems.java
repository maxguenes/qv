package com.techbeat.qv.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Max Guenes on 04/12/2016.
 */

@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
public class ProductOrderItems {

    private Integer id;

    private ProductOrder order;

    private Product product;

    private Integer quantitiy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductOrder getOrder() {
        return order;
    }

    public void setOrder(ProductOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(Integer quantitiy) {
        this.quantitiy = quantitiy;
    }
}
