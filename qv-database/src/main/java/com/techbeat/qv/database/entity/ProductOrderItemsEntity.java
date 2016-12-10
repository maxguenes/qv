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
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_order_id",nullable = false)
    private ProductOrderEntity productOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name="quantity", nullable = false)
    private Integer quantitiy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(Integer quantitiy) {
        this.quantitiy = quantitiy;
    }
}
