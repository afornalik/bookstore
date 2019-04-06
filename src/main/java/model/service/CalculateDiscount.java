package model.service;

import model.Book;
import model.Product;
import model.product.Audio;
import model.product.Poster;
import model.service.discount.AudioDiscount;
import model.service.discount.BookDiscount;
import model.service.discount.PosterDiscount;
import model.type.PaperBook;

import java.util.ArrayList;
import java.util.List;

public class CalculateDiscount{


    private List<Product> product;
    private List<Product> tempProduct = new ArrayList<>();
    private DiscountInterface discountInterface ;

    public CalculateDiscount(List<Product> product) {
        this.product = product;
    }

    public List<Product> calculateDiscount() {
        int posterCounter= 0 ;
        for(int i = 0 ; i < product.size(); i ++) { // try use chain of responsibilities pattern
            if (product.get(i) instanceof Audio) {

                discountInterface = new AudioDiscount(product.get(i));
                product.set(i,discountInterface.updateDiscountPrice());

            }
            if(product.get(i) instanceof PaperBook){

                discountInterface = new BookDiscount(product.get(i));
                product.set(i,discountInterface.updateDiscountPrice());

            }if(product.get(i) instanceof Poster){
                tempProduct.add(product.get(i));

                if(tempProduct.size() >=3){


                }

            }
        }
        return product;
    }

}
