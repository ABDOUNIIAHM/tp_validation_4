package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.entity.Product;
import com.example.tp_validation_4.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController implements WebMvcConfigurer {
    private ProductService productService;

    @GetMapping
    public String getAllProducts(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);

        return "list-product";
    }
    @GetMapping("/add-product")
    public String getFormProduct(Model model){

        Product product = new Product();
        model.addAttribute("product",product);
        return "add-product";
    }
    @PostMapping
    public String addProduct(@ModelAttribute("product") Product product){

        productService.create(product);
        return "redirect:/product";
    }
}
