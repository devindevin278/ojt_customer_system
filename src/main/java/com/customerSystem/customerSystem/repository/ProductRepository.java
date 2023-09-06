package com.customerSystem.customerSystem.repository;

import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.model.Product;
import com.customerSystem.customerSystem.model.Product_ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCustomerCin(long cin);

    Product findByCompositekey(Product_ProductType compositekey);
}
