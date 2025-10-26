package com.example;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Base class for all products.
 * Holds shared attributes and ensures proper validation.
 */
public abstract class Product {

    private final UUID id;
    private final String name;
    private final Category category;
    private BigDecimal price;

    protected Product(UUID id, String name, Category category, BigDecimal price) {
        if (id == null) throw new IllegalArgumentException("ID cannot be null");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Product name cannot be blank");
        if (category == null) throw new IllegalArgumentException("Category cannot be null");
        if (price == null) throw new IllegalArgumentException("Price cannot be null");

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public UUID uuid() {
        return id;
    }

    public String name() {
        return name;
    }

    public Category category() {
        return category;
    }

    public BigDecimal price() {
        return price;
    }

    // Setter
    public void price(BigDecimal newPrice) {
        if (newPrice == null) throw new IllegalArgumentException("Price cannot be null");
        this.price = newPrice;
    }

    public abstract String productDetails();

    @Override
    public String toString() {
        return String.format("%s (%s) - %s kr", name, category.getName(), price);
    }
}
