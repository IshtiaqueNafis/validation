package com.example.challeng2.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

public class Item {
    private String name;
    private double price;
    private double discount;
    private Categories categoryName;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Categories getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Categories categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", categoryName=" + categoryName +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
