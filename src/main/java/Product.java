import java.math.BigDecimal;

public abstract class Product {

    private final long id;
    private String name;
    private BigDecimal price;

    public Product(long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}
