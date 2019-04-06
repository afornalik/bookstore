import model.Product;
import model.product.Audio;
import model.product.Poster;
import model.product.track.Track;
import model.service.discount.AudioDiscount;
import model.service.discount.BookDiscount;
import model.type.PaperBook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class CalculateDiscountTest {

    @Test
    public void shouldDoBookDiscount() {
        //given
        Product book = new PaperBook(1,"aa",new BigDecimal("100"),"aaa",150);
        Product book2 = new PaperBook(1,"aa",new BigDecimal("100"),"aaa",350);
        BookDiscount bookDiscount = new BookDiscount(book);
        BookDiscount bookDiscount2 = new BookDiscount(book2);

        //when
       bookDiscount.updateDiscountPrice();
       bookDiscount2.updateDiscountPrice();

        //then
        Assert.assertEquals(book.getDiscountPrice(),new BigDecimal("90.00"));
        Assert.assertEquals(book2.getDiscountPrice(),new BigDecimal("70.00"));
    }


    @Test
    public void shouldDoAudioDiscount(){
        //given
        List<Track> tracks = new ArrayList<>();
        Product audio1 = new Audio(1,"bb",new BigDecimal("100"), LocalDate.of(1990,1,11),tracks);
        Product audio2 = new Audio(1,"bb",new BigDecimal("100"), LocalDate.of(1999,1,11),tracks);
        Product audio3 = new Audio(1,"bb",new BigDecimal("100"), LocalDate.of(2015,1,11),tracks);
        AudioDiscount audioDiscount = new AudioDiscount(audio1);
        AudioDiscount audioDiscount2 = new AudioDiscount(audio2);
        AudioDiscount audioDiscount3 = new AudioDiscount(audio3);

        //when
        audioDiscount.updateDiscountPrice();
        audioDiscount2.updateDiscountPrice();
        audioDiscount3.updateDiscountPrice();

        //then
        Assert.assertEquals(audio1.getDiscountPrice(),new BigDecimal("71.00"));
        Assert.assertEquals(audio2.getDiscountPrice(),new BigDecimal("80.00"));
        Assert.assertEquals(audio3.getDiscountPrice(),new BigDecimal("96.00"));

    }

}
