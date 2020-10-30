package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book firstBook = new Book(1, "Book 1", 100, "Author 1");
    private Book secondBook = new Book(2, "Book 2", 200, "Author 2");
    private Smartphone firstSmartphone = new Smartphone(3, "3", 300, "Sumsung");
    private Smartphone secondSmartphone = new Smartphone(4, "4", 400, "Iphone");

    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    void getAll() {
        setUp();
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNothing(){
        setUp();
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Nothing");
        assertArrayEquals(expected,actual);
    }

    @Test
    void searchByBookAuthor() {
        setUp();
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Author 1");
        assertArrayEquals(expected, actual);

    }

    @Test
    void searchByBookTitle(){
        setUp();
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Book 1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneTitle(){
        setUp();
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("3");
        assertArrayEquals(expected,actual);
    }

    @Test
    void searchBySmartphoneManufacturer(){
        setUp();
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("Sumsung");
        assertArrayEquals(expected,actual);
    }

}