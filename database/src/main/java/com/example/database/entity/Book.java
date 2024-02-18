package com.example.database.entity;

import java.math.BigDecimal;

public class Book {

    private Long id;
    private String title;
    private BigDecimal price;
    private Long quantity;

    public Long getBookId() {
        return id;
    }

    public void setBookId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

