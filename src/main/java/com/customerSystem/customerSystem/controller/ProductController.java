package com.customersystem.customersystem.controller;

import com.customersystem.customersystem.model.Product;
import com.customersystem.customersystem.service.ProductService;
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
    public Product addProduct(@RequestParam Long cin, @RequestParam Long product_id, @RequestParam Long account_id) {
        return productService.addProduct(cin, product_id, account_id);
    }

    @PostMapping("closeProduct")
    public Product closeProduct(@RequestParam Long account_id, @RequestParam Long product_id) {
        return productService.closeProduct(account_id, product_id);
    }

}
