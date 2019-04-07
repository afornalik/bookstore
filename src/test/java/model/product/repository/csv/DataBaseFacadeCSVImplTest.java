package model.product.repository.csv;

import model.Product;
import model.type.PaperBook;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DataBaseFacadeCSVImplTest {

    @Test
    public void shouldReadFromFile(){
        List<? extends Product> productList = new DataBaseFacadeCSVImpl().getAllProduct();
        productList.forEach(System.out::print);
    }

}