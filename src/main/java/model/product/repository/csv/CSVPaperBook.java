package model.product.repository.csv;

import com.opencsv.bean.CsvBindByName;
import model.Product;
import model.type.PaperBook;

import java.math.BigDecimal;

public class CSVPaperBook implements CSVProductEntity{

    @CsvBindByName(column = "id" , required = true)
    private Long id;

    @CsvBindByName(column = "name" , required = true)
    private String name;

    @CsvBindByName(column = "price" , required = true)
    private String price;

    @CsvBindByName(column = "author" , required = true)
    private String author;

    @CsvBindByName(column = "pageCounter" , required = true)
    private Integer pageCounter;


    @Override
    public PaperBook toProduct() {
        return new PaperBook(id,name,new BigDecimal(price),author,pageCounter);
    }
}
