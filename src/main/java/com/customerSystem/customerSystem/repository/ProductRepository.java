package com.customersystem.customersystem.repository;

import com.customersystem.customersystem.model.Product;
import com.customersystem.customersystem.model.Product_ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCustomerCin(long cin);

    Product findByCompositekey(Product_ProductType compositekey);
}
