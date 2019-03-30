package model.type;

import model.Book;

import java.math.BigDecimal;

public class AudioBook extends Book {

    private int duration;

    public AudioBook(long id, String name, BigDecimal priceString, String author, int pageCounter,int duration) {

        super(id, name, priceString, author, pageCounter);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
