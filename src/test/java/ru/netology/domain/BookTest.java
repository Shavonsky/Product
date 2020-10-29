package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book = new Book(1, "Book", 100, "Author 1");
    private Smartphone smartphone = new Smartphone(2, "20", 10000, "Sunsung");


    @Test
    void MatchesNotSearch() {
        boolean actual = book.matches(book, "Nothing");
        assertEquals(false, actual);
    }

    @Test
    void MatchesBookByTitle() {
        boolean actual = book.matches(book, "Book");
        assertEquals(true, actual);
    }

    @Test
    void MatchesBookByAuthor() {
        boolean actual = book.matches(book, "Author 1");
        assertEquals(true, actual);
    }

    @Test
    void smartphoneNotMatchesBook() {
        boolean actual = book.matches(smartphone, "Sunsung");
        assertEquals(false, actual);
    }

}