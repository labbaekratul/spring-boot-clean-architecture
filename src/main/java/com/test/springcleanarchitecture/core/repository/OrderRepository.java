package com.test.springcleanarchitecture.core.repository;

import com.test.springcleanarchitecture.core.entity.Order;

import java.util.UUID;

public interface OrderRepository {
    void save(Order order);
    Order findById(UUID id);
}
