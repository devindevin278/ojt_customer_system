package com.customersystem.customersystem.mapper;

import com.customersystem.customersystem.model.*;
import com.customersystem.customersystem.modeldto.ProductDto;
import com.customersystem.customersystem.repository.CustomerRepository;
import com.customersystem.customersystem.repository.ProductTypeRepository;
import com.customersystem.customersystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductMapper {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private StatusRepository statusRepository;
    public ProductDto toDto(Product product) {
        Long accoundId = product.getAccount_id();
        String productType = product.getProductType().getName();
        Date created = product.getCreated();
        Long cin = product.getCustomer().getCin();
        String status = product.getStatus().getName();

        return new ProductDto(accoundId, productType, created, cin, status);

    }

    public Product toProduct(ProductDto productDto) {
        Customer customer = customerRepository.findById(productDto.getCin()).orElse(null);
        ProductType productType = productTypeRepository.findByName(productDto.getProductType());
        Status status = statusRepository.findByName(productDto.getStatus());

        return new Product(productDto.getAccoundId(), productType, productDto.getCreated(), customer, status);
    }

}
