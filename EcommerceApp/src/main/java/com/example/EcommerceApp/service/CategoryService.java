package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.CategoryEntity;
import com.example.EcommerceApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public void saveCategory(CategoryEntity entity)
    {
    repository.save(entity);
    }
    public List<CategoryEntity> getAllCategory(){
        return repository.findAll();
    }
    public void deleteCategory(int id){
        repository.deleteById(id);
    }
}
