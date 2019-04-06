import model.Product;
import model.product.Poster;
import model.service.CalculateDiscount;
import model.service.Cart;
import model.service.DiscountInterface;
import model.service.discount.PosterDiscount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class CartTest {


    @Test
    public void shouldDoPosterDiscount() {
        //given
        Product poster1 = new Poster(3,"poster1",new BigDecimal("100"));
        Product poster2 = new Poster(2,"poster2",new BigDecimal("90"));
        Product poster3 = new Poster(1,"poster3",new BigDecimal("100"));
        CalculateDiscount calculateDiscount = new CalculateDiscount(Arrays.asList(poster1,poster2,poster3));
       // DiscountInterface discountInterface = new PosterDiscount(Arrays.asList(poster1,poster2,poster3));

        //when
        calculateDiscount.calculateDiscount();

        //then
        Assert.assertEquals(poster3.getDiscountPrice(),BigDecimal.ONE);




    }
}
