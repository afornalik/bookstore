package model.type;

import model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EBook extends Book {

    private List<String> supportedFormats = new ArrayList<String>();

    public EBook(long id, String name, BigDecimal priceString, String author, int pageCounter, List<String> supportedFormats) {
        super(id, name, priceString, author, pageCounter);
        this.supportedFormats = supportedFormats;
    }

    public List<String> getSupportedFormats() {
        return supportedFormats;
    }

}
