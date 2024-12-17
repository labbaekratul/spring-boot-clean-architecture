package com.test.springcleanarchitecture.adapter.repository;

import com.test.springcleanarchitecture.infrastructure.database.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, UUID> {
}
