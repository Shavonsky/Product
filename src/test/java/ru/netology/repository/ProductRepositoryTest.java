package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book firstBook = new Book(1, "Book 1", 100, "Author 1");
    private Book secondBook = new Book(2, "Book 2", 200, "Author 2");
    private Smartphone firstSmartphone = new Smartphone(3,"Smartphone 1", 300, "Sumsung");
    private Smartphone secondSmartphone = new Smartphone(4,"Smartphone 2", 400, "Iphone");

    @Test
    public void shouldRemoveByBookID() {
        repository.save(firstBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldRemoveBySmartphoneID() {
//        repository.save(firstSmartphone);
//        repository.save(secondSmartphone);
//        Product[] expected = new Product[]{secondSmartphone};
//        repository.removeById(3);
//        Product[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);
//    }

}