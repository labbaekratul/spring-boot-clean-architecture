package com.test.springcleanarchitecture.application.service;



import com.test.springcleanarchitecture.application.dto.OrderDto;
import com.test.springcleanarchitecture.application.usecase.PlaceOrderUseCase;
import com.test.springcleanarchitecture.core.entity.Order;
import com.test.springcleanarchitecture.core.repository.OrderRepository;
import com.test.springcleanarchitecture.core.valueobject.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements PlaceOrderUseCase {

    private final OrderRepository orderRepository;

    @Override
    public void execute(OrderDto orderDto) {
        var items = orderDto.getItems().stream()
                .map(item -> new OrderItem(item.getItemName(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(orderDto.getCustomerName(), items);
        orderRepository.save(order);
    }
}
