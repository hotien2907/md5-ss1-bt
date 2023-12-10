package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ProductController {


    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/product")
    public String index(Model model) {
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "product/index";
    }

    @GetMapping("/product/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/add";
    }

    @PostMapping("/product/add")
    public String processAdd(@ModelAttribute("product") Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.find(id));
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/edit";
    }

    @PostMapping("/product/edit")
    public String processEdit(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
         productService.delete(productService.find(id));
        return "redirect:/";
    }

}
