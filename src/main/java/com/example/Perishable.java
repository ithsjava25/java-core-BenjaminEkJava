package com.example;

import java.time.LocalDate;

/**
 * Interface for products with expiration dates.
 */
public interface Perishable {
    LocalDate expirationDate();

    default boolean isExpired() {
        return expirationDate().isBefore(LocalDate.now());
    }
}
