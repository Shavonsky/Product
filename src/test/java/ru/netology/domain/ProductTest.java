package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(1, "Product", 1000);

    @Test
    void matchesProductTitle() {
        boolean actual = product.matches(product, "Product");
        assertEquals(true, actual);
    }

    @Test
    void matchesNotProduct(){
        boolean actual = product.matches(product, "Nothing");
        assertEquals(false, actual);
    }

}