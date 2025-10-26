package com.example;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * ElectronicsProduct: shippable product with warranty.
 */
public class ElectronicsProduct extends Product implements Shippable {

    private final int warrantyMonths;
    private final BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(id, name, category, price);

        if (warrantyMonths < 0) throw new IllegalArgumentException("Warranty months cannot be negative.");
        if (weight.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Weight months cannot be negative.");

        this.warrantyMonths = warrantyMonths;
        this.weight = Objects.requireNonNull(weight, "Weight cannot be null");
    }

    @Override
    public String productDetails() {
        return "Electronics: %s, Warranty: %d months".formatted(name(), warrantyMonths);
    }

    @Override
    public Double weight() {
        return weight.doubleValue();
    }

    @Override
    public BigDecimal calculateShippingCost() {
        BigDecimal base = BigDecimal.valueOf(79);
        if (weight.doubleValue() > 5.0) base = base.add(BigDecimal.valueOf(49));
        return base;
    }

}
