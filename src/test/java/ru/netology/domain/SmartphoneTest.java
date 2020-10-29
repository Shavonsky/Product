package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(1,"Smartphone",10000,"Sumsung");
    private Book book = new Book(1, "Book", 100, "Author 1");

    @Test
    void matchesNotSearch() {
        boolean actual = smartphone.matches(smartphone, "Nothing");
        assertEquals(false, actual);
    }


    @Test
    void matchesSmartphoneByTitle() {
        boolean actual = smartphone.matches(smartphone, "Smartphone");
        assertEquals(true, actual);
    }

    @Test
    void matchesSmartphoneByManufacturer() {
        boolean actual = smartphone.matches(smartphone, "Sumsung");
        assertEquals(true, actual);
    }

    @Test
    void BookNotMatchesSmartphone() {
        boolean actual = smartphone.matches(book, "Author 1");
        assertEquals(false, actual);
    }
}