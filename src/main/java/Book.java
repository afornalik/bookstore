import java.math.BigDecimal;

public abstract class Book extends Product{

    private final String author;
    private final int pageCounter;

    public Book(long id, String name, BigDecimal priceString,String author, int pageCounter) {
        super(id,name,priceString);
        this.author = author;
        this.pageCounter = pageCounter;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCounter() {
        return pageCounter;
    }
}
