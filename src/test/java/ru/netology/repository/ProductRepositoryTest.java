package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book firstBook = new Book(1, "Book 1", 100, "Author 1");
    private Book secondBook = new Book(2, "Book 2", 200, "Author 2");

    @BeforeEach
    void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void shouldRemoveByBookID() {
        repository.removeById(1);
        Product[] expected = new Product[]{secondBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}