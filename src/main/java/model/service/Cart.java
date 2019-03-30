package model.service;

import model.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Cart {

    private List<Product> productInCart;

    public Cart(List<Product> productInCart) {
        this.productInCart = productInCart;
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

    public void printReception() {
        System.out.printf("|%5s|%10s|%10s|%20s|","id","name","price","discount price");
        for(Product product : productInCart){
            System.out.printf("|%5s|%10s|%10s|%20s|",product.getId(),product.getName(),product.getPrice(),product.getPrice().multiply(new BigDecimal(0.8)));
        }
        System.out.println(getCartPrice());

    }
}
