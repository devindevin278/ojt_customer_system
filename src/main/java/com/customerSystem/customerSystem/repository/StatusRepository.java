package com.customersystem.customersystem.repository;

import com.customersystem.customersystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
