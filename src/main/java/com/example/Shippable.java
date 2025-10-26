package com.example;

import java.math.BigDecimal;

/**
 * Interface for products that can be shipped.
 */
public interface Shippable {
    Double weight();
    BigDecimal calculateShippingCost();
}
