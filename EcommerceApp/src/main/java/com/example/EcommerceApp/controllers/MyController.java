package com.example.EcommerceApp.controllers;

import com.example.EcommerceApp.entity.CategoryEntity;
import com.example.EcommerceApp.service.CategoryService;
import com.example.EcommerceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    // Home
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Login
    @GetMapping("/login")
    public String loginFormView() {
        return "loginform";
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    // Category Form
    @GetMapping("/dashboard/category-form")
    public String dashboardCategoryForm(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getAllCategory();
        model.addAttribute("categoryEntityList", categoryEntityList);
        return "DashboardCategoryform";
    }

    // Category Submit
    @PostMapping("/dashboard/category-submit")
    public String dashboardCategorySubmit(@RequestParam("category") String cname) {
        CategoryEntity entity = new CategoryEntity(cname);
        categoryService.saveCategory(entity);
        return "redirect:/dashboard/category-form";
    }

    // Category Delete
    @GetMapping("/dashboard/category-delete/{cid}")
    public String dashboardCategoryDelete(@PathVariable int cid) {
        categoryService.deleteCategory(cid);
        return "redirect:/dashboard/category-form";
    }

    // Product Form
    @GetMapping("/dashboard/product-form")
    public String dashboardProductForm(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getAllCategory();
        model.addAttribute("categoryEntityList", categoryEntityList);
        return "dashboardProductForm";
    }
    @PostMapping("/dashboard/product-save")
    public String saveProduct(
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam int categoryId,
            @RequestParam String details,
            @RequestParam MultipartFile image
    ) {
        // save logic
        return "redirect:/dashboard/product-form";
    }

}
