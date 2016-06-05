package com.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;


@Entity
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int articleId;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private double price;

    @NotNull
    private int stock;

    @NotNull
    private double shoppingPrice;


    public Article(double price, int stock, double shoppingPrice, String name, String description) {
        this.price = price;
        this.stock = stock;
        this.shoppingPrice = shoppingPrice;
        this.name = name;
        this.description = description;
    }
    public Article(double price, int stock, double shoppingPrice, String name) {
        this.price = price;
        this.stock = stock;
        this.shoppingPrice = shoppingPrice;
        this.name = name;
        this.description = description;
    }

    public double getShoppingPrice() {
        return shoppingPrice;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getName() {
        return name;
    }

    public Article() {
    }


}
