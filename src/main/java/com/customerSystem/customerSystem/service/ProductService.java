package com.customerSystem.customerSystem.service;

import com.customerSystem.customerSystem.controller.ProductController;
import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.model.Product;
import com.customerSystem.customerSystem.model.Product_ProductType;
import com.customerSystem.customerSystem.model.Status;
import com.customerSystem.customerSystem.repository.CustomerRepository;
import com.customerSystem.customerSystem.repository.ProductRepository;
//import com.customerSystem.customerSystem.repository.ProductTypeRepository;
import com.customerSystem.customerSystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
//    private ProductTypeRepository productTypeRepository;
    private CustomerRepository customerRepository;
    private StatusRepository statusRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CustomerRepository customerRepository, StatusRepository statusRepository) {
        this.productRepository = productRepository;
//        this.productTypeRepository = productTypeRepository;
        this.customerRepository = customerRepository;
        this.statusRepository = statusRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCin(long cin) {
        return productRepository.findByCustomerCin(cin);
    }


    public Product addProduct(Long cin, Long product_id, Long account_id) {
//        ProductType productType = (ProductType) productTypeRepository.findById(product_id).orElse(null);
        Customer customer = customerRepository.findById(cin).orElse(null);
        Product_ProductType compositekey = new Product_ProductType(account_id, product_id);
        Status open = statusRepository.findById((long)1).orElse(null);

        Product product = new Product(compositekey, null, customer, open);

        return productRepository.save(product);
    }

    public Product closeProduct(Long account_id, Long product_id) {
        Product_ProductType compositekey = new Product_ProductType(account_id, product_id);
        Product product = productRepository.findByCompositekey(compositekey);
        Status closed = statusRepository.findById((long)2).orElse(null);

        product.setStatus(closed);

        return productRepository.save(product);
    }


}
