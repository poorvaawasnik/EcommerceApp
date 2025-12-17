package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.ProductEntity;
import com.example.EcommerceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    public void saveProduct(ProductEntity entity)
    {
        repository.save(entity);
    }
}
