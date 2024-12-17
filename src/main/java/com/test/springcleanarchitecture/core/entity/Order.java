package com.test.springcleanarchitecture.core.entity;

import com.test.springcleanarchitecture.core.valueobject.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private UUID id;
    private String customerName;
    private List<OrderItem> items;
    private BigDecimal totalPrice;

    public Order(String customerName, List<OrderItem> items) {
        this.id = UUID.randomUUID();
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = calculateTotalPrice();
    }

    private BigDecimal calculateTotalPrice() {
        return items.stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
