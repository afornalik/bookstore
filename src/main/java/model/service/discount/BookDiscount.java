package model.service.discount;

import model.Book;
import model.Product;
import model.service.DiscountInterface;

import java.math.BigDecimal;

public class BookDiscount implements DiscountInterface {

    private final Product product;

    public BookDiscount(Product product) {
        this.product = product;
    }

    @Override
    public Product updateDiscountPrice() {
        Book actualProduct =(Book) product;
        int percentageDiscount = (actualProduct.getPageCounter()/100)*10;
        if (percentageDiscount > 40) {
            percentageDiscount = 40;
        }
         product.setDiscountPrice(product.getPrice().multiply(new BigDecimal(percentageDiscount/100)));
        return product;
    }
}
