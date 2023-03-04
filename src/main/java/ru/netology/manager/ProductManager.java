package ru.netology.manager;

import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {

        this.repository = repository;
    }

    public void add(Product product) {

        repository.add(product);
    }




    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                 Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {

        return product.getName().contains(search);
    }



}
