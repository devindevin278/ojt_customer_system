package com.customersystem.customersystem.service;

import com.customersystem.customersystem.model.*;
import com.customersystem.customersystem.repository.CustomerRepository;
import com.customersystem.customersystem.repository.ProductRepository;
//import com.customersystem.customersystem.repository.ProductTypeRepository;
import com.customersystem.customersystem.repository.ProductTypeRepository;
import com.customersystem.customersystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductTypeRepository productTypeRepository;
    private CustomerRepository customerRepository;
    private StatusRepository statusRepository;
    private RestTemplate restTemplate;
    @Value("${endpoint.find_deposit}")
    private String find_deposit;
    @Value("${endpoint.find_loan}")
    private String find_loan;

    @Autowired
    public ProductService(ProductRepository productRepository, CustomerRepository customerRepository, StatusRepository statusRepository, RestTemplate restTemplate, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.customerRepository = customerRepository;
        this.statusRepository = statusRepository;
        this.restTemplate = restTemplate;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCin(long cin) {
        return productRepository.findByCustomerCin(cin);
    }


    public Product addProduct(Long cin, Long product_id, Long account_id) {

        String url = (product_id == 1) ? find_deposit : find_loan;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("account_id", account_id);

        String finalUrl = builder.toUriString();

        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(finalUrl, null, Object.class);

//        not found
        if(responseEntity.getBody() ==  null) {
            return null;
        } else { // found
            Customer customer = customerRepository.findById(cin).orElse(null);
//            Product_ProductType compositekey = new Product_ProductType(account_id, product_id);
            ProductType productType = productTypeRepository.findById(product_id).orElse(null);
            Status open = statusRepository.findById((long)1).orElse(null);

            Product product = new Product(account_id, productType, null, customer, open);

            return productRepository.save(product);
        }

    }

    public Product closeProduct(Long account_id, Long product_id) {

        Product product = productRepository.findByAccount_IdAndProductType_Id(account_id, product_id);
        Status closed = statusRepository.findById((long)2).orElse(null);

        product.setStatus(closed);

        return productRepository.save(product);
    }


}
