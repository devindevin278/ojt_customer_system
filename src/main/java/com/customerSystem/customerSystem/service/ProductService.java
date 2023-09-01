package com.customerSystem.customerSystem.service;

import com.customerSystem.customerSystem.controller.ProductController;
import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.model.Product;
import com.customerSystem.customerSystem.model.ProductType;
import com.customerSystem.customerSystem.repository.CustomerRepository;
import com.customerSystem.customerSystem.repository.ProductRepository;
import com.customerSystem.customerSystem.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductTypeRepository productTypeRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.customerRepository = customerRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCin(long cin) {
        return productRepository.findByCustomerCin(cin);
    }


    public Product addProduct(Long cin, Long product_id) {
        ProductType productType = (ProductType) productTypeRepository.findById(product_id).orElse(null);
        Customer customer = customerRepository.findById(cin).orElse(null);

        Product product = new Product(null, customer, productType);

        return productRepository.save(product);
    }


}
