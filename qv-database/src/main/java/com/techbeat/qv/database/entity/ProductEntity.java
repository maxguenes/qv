package com.techbeat.qv.database.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.techbeat.qv.models.Unit;

/**
 * Created by Max Guenes on 04/12/2016.
 */
@Entity(name = "product")
public class ProductEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;
    
    @Column(name="unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL)
    private StockEntity stock;

    @Column(name="value", nullable = false)
    private double value;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Unit getUnit() {
		return unit;
	}
    
    public void setUnit(Unit unit) {
		this.unit = unit;
	}
    
    public StockEntity getStock() {
		return stock;
	}
    
    public void setStock(StockEntity stock) {
		this.stock = stock;
	}

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
