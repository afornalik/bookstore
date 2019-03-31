package model.service.discount;

import model.Book;
import model.Product;
import model.service.DiscountInterface;

import java.math.BigDecimal;
import java.math.MathContext;

public class BookDiscount implements DiscountInterface {

    private final Product product;

    public BookDiscount(Product product) {
        this.product = product;
    }

    @Override
    public Product updateDiscountPrice() {
        Book actualProduct =(Book) product;
        int percentageDiscount = ((actualProduct.getPageCounter()/100)*10);

        if (percentageDiscount > 40) {
            percentageDiscount = 40;
        }
        System.out.println((100 - percentageDiscount)*0.01);
        double percentageDiscount2 = (100 - percentageDiscount)*0.01;
         product.setDiscountPrice(product.getPrice().multiply(new BigDecimal(percentageDiscount2)));
         product.setDiscountPrice(product.getDiscountPrice().round(new MathContext(4)));
        return product;
    }
}
