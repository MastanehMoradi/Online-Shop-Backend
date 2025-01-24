package com.example.shop_store_back.data;//package org.example.data;
//
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String detail;
    private ProductCategory category;
    private String backgroundImage;
    private int score;
    private int count;
    private int price;

    public Product() {
    }

    public Product(String name, String detail, ProductCategory category, String backgroundImage, int score, int count, int price) {
        this.name = name;
        this.detail = detail;
        this.category = category;
        this.backgroundImage = backgroundImage;
        this.score = score;
        this.count = count;
        this.price= price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", category=" + category +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", score=" + score +
                ", count=" + count +
                '}';
    }
}
