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
        System.out.println("reception on date " + "\n"+ LocalDateTime.now());
        for(Product product : productInCart){
            System.out.println(product.getName() +"  -  "+product.getPrice());
        }
        System.out.println(getCartPrice());

    }
}
