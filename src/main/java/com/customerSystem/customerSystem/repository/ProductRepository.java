package com.customerSystem.customerSystem.repository;

import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("SELECT p FROM Product p JOIN FETCH p.productType name")
//    List<Product> findAll();
    List<Product> findByCustomerCin(long cin);

//    @Query("SELECT p FROM Product p JOIN FETCH ProductType pt ON p.ProductType_id = pt.id")
//    List<Product> findByCustomerId(Long cin);
}
