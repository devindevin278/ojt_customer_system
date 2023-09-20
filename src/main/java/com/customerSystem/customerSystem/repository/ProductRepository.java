package com.customersystem.customersystem.repository;

import com.customersystem.customersystem.model.Product;
import com.customersystem.customersystem.model.Product_ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCustomerCin(long cin);

    @Query(value = "SELECT * FROM Product WHERE account_id = :account_id and product_type_id = :product_type_id", nativeQuery = true)
    Product findByAccount_IdAndProductType_Id(@Param("account_id") Long account_id, @Param("product_type_id") Long product_type_id);
}
