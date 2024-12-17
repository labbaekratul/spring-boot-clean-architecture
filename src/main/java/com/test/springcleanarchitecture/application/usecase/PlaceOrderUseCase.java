package com.test.springcleanarchitecture.application.usecase;


import com.test.springcleanarchitecture.application.dto.OrderDto;

public interface PlaceOrderUseCase {
    void execute(OrderDto orderDto);
}
