package com.test.springcleanarchitecture.infrastructure.database;


import com.test.springcleanarchitecture.core.entity.Order;
import com.test.springcleanarchitecture.core.valueobject.OrderItem;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@ToString
@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String customerName;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> items;

    private BigDecimal totalPrice;

    public static OrderEntity fromDomain(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setCustomerName(order.getCustomerName());
        entity.setItems(order.getItems());
        entity.setTotalPrice(order.getTotalPrice());
        return entity;
    }

    public Order toDomain() {
        return new Order(id, customerName, items, totalPrice);
    }
}
