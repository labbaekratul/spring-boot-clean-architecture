package com.test.springcleanarchitecture.adapter.repository;


import com.test.springcleanarchitecture.core.entity.Order;
import com.test.springcleanarchitecture.core.repository.OrderRepository;
import com.test.springcleanarchitecture.infrastructure.database.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JpaOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository repository;

    @Override
    public void save(Order order) {
        OrderEntity entity = OrderEntity.fromDomain(order);
        repository.save(entity);
    }

    @Override
    public Order findById(UUID id) {
        return repository.findById(id).map(OrderEntity::toDomain).orElse(null);
    }
}
