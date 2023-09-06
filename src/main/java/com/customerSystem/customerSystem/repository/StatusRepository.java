package com.customerSystem.customerSystem.repository;

import com.customerSystem.customerSystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
