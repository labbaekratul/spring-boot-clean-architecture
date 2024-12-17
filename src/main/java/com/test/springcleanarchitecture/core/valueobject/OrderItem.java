package com.test.springcleanarchitecture.core.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private String itemName;
    private int quantity;
    private BigDecimal price;
}
