package com.example.EcommerceApp.controllers;


import com.example.EcommerceApp.entity.CategoryEntity;
import com.example.EcommerceApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String loginFormView(){
        return "loginform";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @RequestMapping("/Dashboard/Categoryform")
    public String DashboardCategoryform(Model model){
        List<CategoryEntity> categoryEntityList=categoryService.getAllCategory();
        model.addAttribute("categoryEntityList",categoryEntityList);
        return "DashboardCategoryform";
    }

    @RequestMapping("/dashboard/categorysubmit")
    public String dashboardCategorySubmit(@RequestParam ("category") String cname){
        CategoryEntity entity = new CategoryEntity(cname);
        categoryService.saveCategory(entity);
        return "redirect:/Dashboard/Categoryform";

    }
    @RequestMapping("/dashboard/categorydelete/{cid}")
    public String dashboardCategoryDelete(@PathVariable("cid") String cid)
    {
        int id=Integer.parseInt(cid);
        categoryService.deleteCategory(id);
        return "redirect:/Dashboard/Categoryform";
    }
}
