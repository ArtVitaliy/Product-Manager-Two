package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {


    @Test
    public void testAdd() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);


        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(1, "BookTwo", 200, "Ф.Достоевский");
        Book book3 = new Book(1, "BookThree", 200, "Л.Толстой");
        Book book4 = new Book(1, "BookOneFour", 200, "А.Куприн");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3, book4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchWhenFewProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);


        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("BookOne");
        Product[] expected = {book1, book4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchWhenOneProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("OneFour");
        Product[] expected = {book4} ;
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSearchWhenDoesNotFindProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("BookFour");
        Product[] expected = {} ;
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testAddSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "iphone", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "S3", 800, "Samsung");
        Smartphone smartphone3 = new Smartphone(3, "M5", 600, "Xiaomi");
        Smartphone smartphone4 = new Smartphone(4, "One", 900, "Honor");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = repository.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3, smartphone4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testManufacturer() {

        Smartphone smartphone1 = new Smartphone(1, "iphone", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "S3", 800, "Samsung");
        Smartphone smartphone3 = new Smartphone(3, "M5", 600, "Xiaomi");
        Smartphone smartphone4 = new Smartphone(4, "One", 900, "Honor");

        String actual = smartphone1.getManufacturer();
        String expected = "Apple";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAuthor() {

        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        String actual = book2.getAuthor();
        String expected = "Ф.Достоевский" ;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testGetPrice() {

        Book book1 = new Book(1, "BookOne", 200, "М.Горький");
        Book book2 = new Book(2, "BookTwo", 400, "Ф.Достоевский");
        Book book3 = new Book(3, "BookThree", 600, "Л.Толстой");
        Book book4 = new Book(4, "BookOneFour", 800, "А.Куприн");

        int actual = book2.getPrice();
        int expected = 400 ;
        Assertions.assertEquals(expected, actual);
    }
}




