package com.customersystem.customersystem.repository;

import com.customersystem.customersystem.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findByName(String name);
}
