package com.ra.controller;
import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
     @GetMapping("/")
    public String home (Model model){
         List<Category> list = categoryService.findAll();
         model.addAttribute("list",list);
         return "home";
     }
    @GetMapping("/delete/{id}")
    public String deleteCategory( @PathVariable("id") int id  ){
         categoryService.delete(id);
         return "redirect:/";
    }
    @GetMapping("/add/category")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "create-category";
    }
    @PostMapping("/create/category")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.saveOrUpdate(category);
        return "redirect:/";
    }

    @GetMapping("/edit/category/{id}")
    public String editCategory(Model model,@PathVariable("id") int id ) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }


    @PostMapping("/update/category")
    public String updateCategory(@ModelAttribute("category") Category category) {
        System.out.println(category);
          categoryService.saveOrUpdate(category);
        return "redirect:/";
    }

}
