package com.techbeat.qv.database.entity;

import javax.persistence.*;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Entity(name = "product_order_items")
public class ProductOrderItemsEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_order_id",nullable = false)
    private ProductOrderEntity productOrder;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name="quantity", nullable = false)
    private int quantitiy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductOrderEntity getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(ProductOrderEntity productOrder) {
		this.productOrder = productOrder;
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
}
