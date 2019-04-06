package model.service.discount;

import model.Product;
import model.product.Poster;
import model.service.DiscountInterface;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PosterDiscount implements DiscountInterface {


    private List<Product> product;

    public PosterDiscount(List<Product> product) {
        this.product = product;
    }

    @Override
    public Product updateDiscountPrice() {
      product = product.stream()
              .sorted(Comparator.comparing(Product::getPrice))
              .collect(Collectors.toList());

        return product.get(1);
    }


}
