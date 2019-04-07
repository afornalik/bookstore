package model.product.repository.csv;

import model.Product;

public interface CSVProductEntity<T extends Product> {

     T toProduct();
}
