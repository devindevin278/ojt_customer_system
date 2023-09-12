package com.customersystem.customersystem.service;

import com.customersystem.customersystem.model.Customer;
import com.customersystem.customersystem.model.Product;
import com.customersystem.customersystem.model.Product_ProductType;
import com.customersystem.customersystem.model.Status;
import com.customersystem.customersystem.repository.CustomerRepository;
import com.customersystem.customersystem.repository.ProductRepository;
//import com.customersystem.customersystem.repository.ProductTypeRepository;
import com.customersystem.customersystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
//    private ProductTypeRepository productTypeRepository;
    private CustomerRepository customerRepository;
    private StatusRepository statusRepository;
    @Value("${endpoint.find_deposit}")
    private String find_deposit;
    @Value("${endpoint.find_loan}")
    private String find_loan;

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
        String url;

//        cari dulu di deposit system dan loan system
        if(product_id == 1) {
            url = find_deposit;
        } else {
            url = find_loan;
        }



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
