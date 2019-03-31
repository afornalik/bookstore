package model.service;

import model.Book;
import model.Product;
import model.product.Audio;
import model.service.discount.AudioDiscount;
import model.service.discount.BookDiscount;
import model.type.PaperBook;

import java.util.List;

public class CalculateDiscount{


    private List<Product> product;
    private DiscountInterface discountInterface ;

    public CalculateDiscount(List<Product> product) {
        this.product = product;
    }

    public List<Product> calculateDiscount() {
        for(int i = 0 ; i < product.size(); i ++) { // try use chain of responsibilities pattern
            if (product.get(i) instanceof Audio) {
                discountInterface = new AudioDiscount(product.get(i));

                product.set(i,discountInterface.updateDiscountPrice());
            }
            if(product.get(i) instanceof PaperBook){
                discountInterface = new BookDiscount(product.get(i));

                product.set(i,discountInterface.updateDiscountPrice());
            }
        }
        return product;
    }

}
