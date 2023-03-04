package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.NotFoundException;
import ru.netology.manager.ProductManager;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;


public class ProductRepositoryTest {

    @Test
    public void addTest() {
        Product product1 = new Product(1, "name1", 200);
        Product product2 = new Product(2, "name2", 400);
        Product product3 = new Product(3, "name3", 800);
        Product product4 = new Product(4, "name4", 900);

        ProductRepository repository = new ProductRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testRemoveByIdWhenProductExist() {
        Product product1 = new Product(1, "name1", 200);
        Product product2 = new Product(2, "name2", 400);
        Product product3 = new Product(3, "name3", 800);
        Product product4 = new Product(4, "name4", 900);

        ProductRepository repository = new ProductRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.removeById(4);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveByIdWhenProductExistBook() {
        ProductRepository repository = new ProductRepository();


        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);

        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {book2, book3, book4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveByIdWhenProductNotExist() {
        ProductRepository repository = new ProductRepository();


        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);


        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeById(5));
    }

}
