package com.customerSystem.customerSystem.repository;

import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
