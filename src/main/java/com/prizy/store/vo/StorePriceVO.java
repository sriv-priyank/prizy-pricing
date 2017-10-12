package com.prizy.store.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StorePriceVO {

    private String store;
    private String product;
    private Double price;
    private String notes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private Date created;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
