package model.service.discount;

import model.Product;
import model.product.Poster;
import model.service.DiscountInterface;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PosterDiscount implements DiscountInterface {


    private Product product;

    public PosterDiscount(Product product) {
        this.product = product;
    }

    @Override
    public Product updateDiscountPrice() {
        product.setDiscountPrice(BigDecimal.ONE);
        return product;
    }


}
