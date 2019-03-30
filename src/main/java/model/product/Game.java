package model.product;

import model.Product;

import java.math.BigDecimal;

public class Game extends Product {

    private final String publisher;
    public Game(long id, String name, BigDecimal price, String publisher) {
        super(id, name, price);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }
}
