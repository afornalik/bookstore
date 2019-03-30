package model.service.discount;

import model.Product;
import model.product.Audio;
import model.service.DiscountInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class AudioDiscount implements DiscountInterface {

    private final Product product;

    public AudioDiscount(Product product) {
        this.product = product;
    }

    @Override
    public Product updateDiscountPrice() {

        Audio audioObject = (Audio) product;
        LocalDate publishDate = audioObject.getPublishmentDate();

        Period between = Period.between(publishDate,LocalDate.now());
        System.out.println(between.getYears());
        BigDecimal percentageValue = new BigDecimal((100-between.getYears())*0.01);
        System.out.println(percentageValue);


        product.setDiscountPrice(product.getPrice().multiply(percentageValue));
        return product;
    }
}
