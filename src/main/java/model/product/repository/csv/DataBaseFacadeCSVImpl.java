package model.product.repository.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import model.Product;
import model.product.repository.DataBaseFacade;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseFacadeCSVImpl implements DataBaseFacade {


    @Override
    public Product getProduct(long id) {
        return null;
    }

    @Override
    public List<? extends Product> getAllProduct() {
        try {
            List<CSVPaperBook> beans = new CsvToBeanBuilder(new FileReader("paperbook.csv"))
                    .withType(CSVPaperBook.class).build().parse();

            return beans.stream().map(x -> x.toProduct()).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void addManyProduct(Collection<Product> products) {

    }

    @Override
    public void update(Product updaProduct) {

    }

    @Override
    public void removeProduct(Product product) {

    }
}
