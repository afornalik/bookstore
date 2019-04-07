import model.Product;
import model.product.Audio;
import model.product.track.Track;
import model.service.Cart;
import model.type.AudioBook;
import model.type.PaperBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product = new AudioBook(3, "Java Podstawy", new BigDecimal(87.6), "Kowalski", 876, 90000);
        Product product1 = new AudioBook(1, "Java", new BigDecimal(33.6), "Kowalski", 876, 90000);
        Product product2 = new AudioBook(6, "Algebra", new BigDecimal(17.6), "Kowalski", 876, 90000);
        Product product3 = new PaperBook(3, "Atlas", new BigDecimal(43.3), "Nowak", 300);
        Product product4 = new PaperBook(3, "Atlas Świata", new BigDecimal(165.3), "Nowak", 120);
        List<Track> tracks = new ArrayList<>();
        Product audio = new Audio(11,"Smerfne hity",new BigDecimal(100), LocalDate.of(1990,11,22),tracks);

        List<Product> productList = new ArrayList<>();

        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(audio);
        productList.add(product4);

        Cart cart = new Cart(productList);

        cart.printReception();



        try {
            FileOutputStream fileOutputStream = new FileOutputStream("paperbook.csv",true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
