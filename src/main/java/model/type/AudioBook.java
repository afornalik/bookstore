package model.type;

import model.Book;

import java.math.BigDecimal;

public class AudioBook extends Book {

    public AudioBook(long id, String name, BigDecimal priceString, String author, int pageCounter) {
        super(id, name, priceString, author, pageCounter);
    }
}
