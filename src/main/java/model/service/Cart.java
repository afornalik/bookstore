package model.service;

import model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Cart {

    private List<Product> productInCart;
    private CalculateDiscount calculateDiscount;

    public Cart(List<Product> productInCart) {
        this.productInCart = productInCart;
        calculateDiscount = new CalculateDiscount(productInCart);
    }

    public void addProductToCart(Product product) {
        productInCart.add(product);
    }

    public void removeProductByIndex(int index){
        productInCart.remove(index);
    }

    public void remoteProduct(Product product){
        productInCart.remove(product);
    }

    public BigDecimal getCartPrice() {
        return productInCart
                .stream()
                .map(price -> price.getPrice())
                .reduce(BigDecimal.ZERO, (sumPrice,actualPrice) -> sumPrice.add(actualPrice));
    }

    public BigDecimal getCartPriceAfterDiscount() {
        return productInCart
                .stream()
                .map(x -> x.getDiscountPrice())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }



    public void printReception() {
        productInCart = calculateDiscount.calculateDiscount();
        System.out.printf("|%5s|%20s|%10s|%20s|\n\n","id","name","price","discount price");
        for(Product product : productInCart){
            System.out.printf("|%5d|%20s|%10.5s|%20.5s|\n",product.getId(),product.getName(),product.getPrice(),product.getDiscountPrice());
        }
        System.out.println("\n\n");
        System.out.printf("Total Price -  %10.5s\n",getCartPrice());
        System.out.printf("Total Price after discount -  %10.5s\n\n\n",getCartPriceAfterDiscount());

    }
}
