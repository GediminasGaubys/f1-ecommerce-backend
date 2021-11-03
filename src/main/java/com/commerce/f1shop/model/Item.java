package com.commerce.f1shop.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "racerId")
    private Long racerId;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantityInStock")
    private Integer quantityInStock;

    @Column(name = "shippingInformation")
    private String shippingInformation;

    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRacerId() {
        return racerId;
    }

    public void setRacerId(Long racerId) {
        this.racerId = racerId;
    }

    public Integer getQuantity() {
        return quantityInStock;
    }

    public void setQuantity(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(String shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}