package com.example.EcommerceApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;
    private String cname;

    public CategoryEntity(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "cname='" + cname + '\'' +
                ", id=" + id +
                '}';
    }

    public CategoryEntity() {
    }
}
