import model.Product;
import model.service.discount.BookDiscount;
import model.type.PaperBook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

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
}
