package com.customerSystem.customerSystem.repository;

import com.customerSystem.customerSystem.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
