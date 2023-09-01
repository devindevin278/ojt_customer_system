package com.customerSystem.customerSystem.controller;

import com.customerSystem.customerSystem.model.Product;
import com.customerSystem.customerSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    // to find products owned by a customer
    @GetMapping("{cin}")
    public List<Product> findByCustomerCin(@PathVariable long cin) {
        return productService.findByCin(cin);
    }

    @PostMapping("addProduct")
    public Product addProduct(@RequestParam Long cin, @RequestParam Long product_id) {
        return productService.addProduct(cin, product_id);
//        return cin.toString();
    }

//    @GetMapping("")

}
