package com.test.springcleanarchitecture.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private String customerName;
    private List<OrderItemDto> items;

    @Data
    public static class OrderItemDto {
        private String itemName;
        private int quantity;
        private BigDecimal price;
    }
}
