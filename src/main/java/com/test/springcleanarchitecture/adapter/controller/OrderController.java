package com.test.springcleanarchitecture.adapter.controller;


import com.test.springcleanarchitecture.application.dto.OrderDto;
import com.test.springcleanarchitecture.application.usecase.PlaceOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
        placeOrderUseCase.execute(orderDto);
        return ResponseEntity.ok("Order placed successfully!");
    }
}
