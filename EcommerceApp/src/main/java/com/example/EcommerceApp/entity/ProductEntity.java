package com.example.EcommerceApp.entity;

import jakarta.persistence.*;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int price;
    private String detail;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    private String image;

    public ProductEntity(CategoryEntity category, String detail, String image, String name, int price) {

        this.category = category;
        this.detail = detail;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductEntity() {
    }
}
