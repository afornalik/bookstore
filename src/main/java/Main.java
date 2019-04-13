import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import model.product.Audio;
import model.product.Poster;
import model.product.repository.nbp.ExchangeRate;
import model.product.repository.nbp.NBPRepository;
import model.product.repository.nbp.SingleRate;
import model.product.track.Track;
import model.service.Cart;
import model.type.AudioBook;
import model.type.PaperBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product = new AudioBook(3, "Java Podstawy", new BigDecimal(87.6), "Kowalski", 876, 90000);
        Product product1 = new AudioBook(1, "Java", new BigDecimal(33.6), "Kowalski", 876, 90000);
        Product product2 = new AudioBook(6, "Algebra", new BigDecimal(17.6), "Kowalski", 876, 90000);
        Product product3 = new PaperBook(3, "Atlas", new BigDecimal(43.3), "Nowak", 300);
        Product product4 = new PaperBook(3, "Atlas Świata", new BigDecimal(165.3), "Nowak", 120);
        List<Track> tracks = new ArrayList<>();
        Product audio = new Audio(11, "Smerfne hity", new BigDecimal(100), LocalDate.of(1990, 11, 22), tracks);
        Product poster1 = new Poster(544,"Jaś Fasola poster",new BigDecimal("200.4"));
        Product poster2 = new Poster(22,"Jaś Fasola poster2",new BigDecimal("332.4"));
        Product poster3 = new Poster(34,"Jaś Fasola poster3",new BigDecimal("42.4"));
        Product poster4 = new Poster(54,"Jaś Fasola poster4",new BigDecimal("32.4"));
        Product poster5 = new Poster(333,"Jaś Fasola poster5",new BigDecimal("34.8"));

        List<Product> productList = new ArrayList<>();

        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(audio);
        productList.add(product4);

        productList.addAll(Arrays.asList(poster1,poster2,poster3,poster4,poster5));

        Cart cart = new Cart(productList);
        cart.printReception();

        NBPRepository nbpRepository = new NBPRepository();
        String str = nbpRepository.getResponse();

        List<ExchangeRate> exchangeRateList = getExchangeRates(str);

        for (ExchangeRate exchangeRate : exchangeRateList) {
            for (SingleRate singleRate : exchangeRate.getRates()) {
                System.out.println("Total price after discont in :  "
                        + singleRate.getCode() + "\t "
                        + cart.getCartPriceAfterDiscount()
                        .divide(BigDecimal.valueOf(singleRate.getCurrencyBuyCourse()), 2, BigDecimal.ROUND_HALF_UP));

            }
        }


//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("paperbook.csv",true);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private static List<ExchangeRate> getExchangeRates(String str) {
        ObjectMapper mapper = new ObjectMapper();
        List<ExchangeRate> exchangeRateList = null;
        try {
            exchangeRateList = mapper.readValue(
                    str,
                    new TypeReference<List<ExchangeRate>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exchangeRateList;
    }
}
